package com.at.statestreet.a221130;


import java.util.Arrays;
import java.util.UUID;

public class StackTest {
    public static void main(String[] args) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push("a");
        arrayStack.push("a");
        arrayStack.push("ab");
        arrayStack.pop();
        arrayStack.pop();
        arrayStack.pop();
        System.out.println(Arrays.toString(arrayStack.data));

        LinkedStack linkedStack = new LinkedStack(3);
        linkedStack.push("bb123");
        linkedStack.push("bb2");
        linkedStack.push("bb");
        linkedStack.pop();
        linkedStack.push("bb");
        linkedStack.push("bb1");

        Node data = linkedStack.data;
        while (data != null){
            System.out.print(data.value + " ");
            data = data.next;
       }
    }
}

/**
 * 栈 主要包含出栈和入栈这两种操作
 */
class ArrayStack{
    String[] data;
    int count;
    int capacity;
    public ArrayStack(int size){
        this.capacity = size;
        this.data = new String[size];
    }

    public  boolean push(String value){
        if(capacity == count)return false;
        data[count++] = value;
        return true;
    }

    public  String pop(){
        if(count == 0) return null;
        return data[--count];
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                "data=" + Arrays.toString(data) +
                '}';
    }
}


class LinkedStack{
    Node data = new Node("",null);
    int capacity;
    int count;

    public LinkedStack(int size){
        this.capacity = size;
    }

    public boolean push(String value){
        if(capacity == count) return  false;
        //插入头部
        Node node = new Node(value, null);
        node.next = data;
        data = node;
        count ++;
        return  true;
    }

    public String pop(){
        if(count < 0 )return null;
        String value = data.value;
        data = data.next;
        count--;
        return value;

    }
}
 class Node{
    Node next;
    String value;
    public Node(String value,Node node){
        this.value = value;
        this.next = node;
    }
    public String getValue(){
        return value;
    }

}