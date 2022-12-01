package com.at.statestreet.a221130;

import com.google.common.collect.ImmutableList;
import org.apache.commons.lang3.StringUtils;
import sun.applet.Main;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class DequeTest {
    public static void main(String[] args) {
        LinkedDeque linkedDeque = new LinkedDeque();
        linkedDeque.enQueue("a");
        linkedDeque.enQueue("a");
        linkedDeque.enQueue("a");
        linkedDeque.enQueue("a");
        linkedDeque.deQueue();
        linkedDeque.deQueue();
        linkedDeque.enQueue("a1");
        linkedDeque.enQueue("a2");
        linkedDeque.deQueue();

        linkedDeque.enQueue("a3");
        linkedDeque.deQueue();

        linkedDeque.print();
    }
}

/**
 * 基于单向链表实现队列
 */

class LinkedDeque{
    Node head ;
    Node current;

    public  boolean enQueue(String value){
        Node node = new Node(value,null);
        if(head == null){
            head = node;
            current = node;
            return true;
        }
        current.next = node;
        current = current.next;
        return  true;
    }

    public String deQueue(){
        if(head == null){
            current = null;
            return null;
        }
        String value = head.value;
        if(StringUtils.isBlank(value)){
            //空的
            return null;
        }
        head = head.next;
        return value;
    }

    public void print(){
        while (head != null){
            System.out.print(head.value+" ");
            head = head.next;
        }
    }
}

