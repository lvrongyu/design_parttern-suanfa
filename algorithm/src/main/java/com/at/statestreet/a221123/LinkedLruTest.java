package com.at.statestreet.a221123;

import org.omg.CORBA.INTERNAL;

public class LinkedLruTest {
    public static void main(String[] args) {
        ListNode1 listNode1 = new ListNode1(3);


        linkedLru("a",listNode1);
        linkedLru("b",listNode1);
        linkedLru("a",listNode1);
        linkedLru("3",listNode1);
        linkedLru("2",listNode1);
        linkedLru("2",listNode1);
        linkedLru("b",listNode1);
        linkedLru("b",listNode1);
        linkedLru("2",listNode1);

        ListNode1.print(listNode1.head);
    }

    /**
     * 单链表的LRU
     *  1 如果已存在，则将它放在链表头部，已存在的头一个元素指向已存在的下一个元素
     *  2 若不存在
     *      若链表已满，则删除队尾，插入头部
     *      若链表未满，插入头部
     */
    public static void  linkedLru(String value,ListNode1 listNode1){
        int indexByValue = listNode1.findIndexByValue(value);
        if(indexByValue != -1){
            //已存在
            listNode1.remove(indexByValue);
            listNode1.insertToHead(value);
            return;
        }
        if(listNode1.capacity == listNode1.len){
            ListNode1.Node valueByIndex = listNode1.findValueByIndex(listNode1.capacity - 2);
            valueByIndex.next = null;
        }
        listNode1.insertToHead(value);

    }

}
class ListNode1{
    int capacity ;
    int len;
    Node head;
    public ListNode1(int size){
        this.capacity = size;
    }

    public int findIndexByValue(String value){
        Node tmp = head;
        int count = 0;
        while (tmp != null ){
            if(tmp.value.equals(value) )return count;
            tmp = tmp.next;
            count++;
        }
        return -1;
    }
    public Node findValueByIndex(int index){
        Node tmp = head;
        while (index > 0){
            tmp = tmp.next;
            index--;
        }
        return tmp;
    }


    public void remove(int index){
        if(index == 0){
            head = head.next;
        }else {
            Node former = findValueByIndex(index-1);
            Node later = findValueByIndex(index+1);
            former.next = later;
        }
        len--;
    }


    /**
     * 表尾插入
     * @param value
     */
    public void insertToTail(String value){
        Node listNode = new Node(value, null);
        Node tmp = head;
        if(tmp == null){
            head = listNode;
            len++;
            return;
        }
        while (tmp.next != null){
            tmp =  tmp.next;
        }
        tmp.next = listNode;
        len++;
    }

    /**
     * 表头插入
     * @param value
     */
    public void insertToHead(String value){
        Node listNode = new Node(value, null);
        if(head == null){
            head = listNode;
            len++;
            return;
        }
        if(len == capacity){
            //没有位置了
            Node tmp = head;
            for (int i = 0; i < len - 2; i++) {
                tmp = tmp.next;
            }
            tmp.next = null;
        }else {
            len++;
        }
        listNode.next = head;
        head = listNode;
    }

    static class Node{
        Node next;
        String value;
        public Node(String value, Node node){
            this.value = value;
            this.next = node;
        }

    }
    public  static  void  print(Node node){
        Node tmp = node;
        while (tmp != null){
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
    }


}
