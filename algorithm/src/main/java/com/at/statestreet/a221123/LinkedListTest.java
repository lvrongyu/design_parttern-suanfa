package com.at.statestreet.a221123;

import java.util.HashMap;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        String[] sample = {"a","b","c","b","a"};
        ListNode listNode = new ListNode();
        for (String s : sample) {
            listNode.insertToTail(s);
            System.out.println();
        }
        ListNode.print(listNode.head);
        boolean palindromicString = isPalindromicString(listNode.head);
        System.out.println(palindromicString);
    }

    /**
     * 单链表判断回文串--快慢指针
     *      1、快指针到达队尾，满指针找到中间节点
     *      2、慢指针逆序排列
     *      3、慢指针边走边逆序排列
     */
    public static boolean isPalindromicString(ListNode.Node stringList) {
        ListNode.Node fast = stringList;
        ListNode.Node slow = stringList;

        if(fast == null )return false;
        if(fast.next == null)return  true;
        if(fast.next.next == null && fast.value.equals(fast.next.value)) return true;
        if(fast.next.next == null && !fast.value.equals(fast.next.value)) return false;
        ListNode listNode = new ListNode();
        listNode.insertToHead(slow.value);//开始循环之前把头元素的值放入到逆序链表中
        while (fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            listNode.insertToHead(slow.value);//把慢指针走过的值反向保存在另外一个链表中
        }
        System.out.println();
        ListNode.print(listNode.head);
        ListNode.Node head = listNode.head;
        if(fast.next != null){
            //节点数为偶数  偶数的话右边会多一个值，奇数的话正好
            slow = slow.next;
        }
        while (slow != null && head!= null){
            if(slow.value != head.value)return false;
            slow = slow.next;
            head = head.next;
        }
        return true;
    }


}



class ListNode{
    Node head;
    public Node findByValue(String value){
        Node tmp = head;
        while (tmp != null ){
            if(tmp.value.equals(value) )return tmp;
            tmp = tmp.next;
        }
        return null;
    }
    public Node findByIndex(int index){
        Node tmp = head;
        int count = 0;
        while (tmp != null){
            if(index == count)return tmp;
            tmp = tmp.next;
            count++;
        }
        return null;
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
            return;
        }
        while (tmp.next != null){
            tmp =  tmp.next;
        }
        tmp.next = listNode;
    }

    /**
     * 表头插入
     * @param value
     */
    public void insertToHead(String value){
        Node listNode = new Node(value, null);
        if(head == null){
            head = listNode;
            return;
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
        public String getValue(){
            return value;
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