package com.at.statestreet.a221130;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CircleDequeueTest {

    public static void main(String[] args) {
        CircleArrayDequeue circleArrayDequeue = new CircleArrayDequeue(3);
        circleArrayDequeue.enqueue("a");
        circleArrayDequeue.enqueue("a");
        circleArrayDequeue.enqueue("a");

        circleArrayDequeue.dequeue();
        circleArrayDequeue.dequeue();
        circleArrayDequeue.enqueue("a1");
        circleArrayDequeue.enqueue("a2");

        circleArrayDequeue.toString1();

    }
}

/**
 * 使用数组模拟循环队列
 * 队满： （tail+1）% n == head
 * 对空： tail= head;
 */

class CircleArrayDequeue{
    int tail;
    int head;
    String[] data;
    int size;
    public CircleArrayDequeue(int size){
        this.data = new String[size];
        this.size = size;
    }

    public boolean enqueue(String value){
        if((tail+1) % size == head){
            return false;
        }
        data[tail] = value;
        tail = (tail+1) % size;
        return true;
    }

    public String dequeue(){
        if(tail == head){
            return  null;
        }
        String datum = data[head];
        head = (head + 1) % size;
        if(tail == head){
            tail = 0;
            head = 0;
            data = new String[size];
            return  null;
        }
        return datum;
    }

    public void toString1() {
        for (int i = head; i < tail; i++) {
            System.out.print(data[i]+" ");
        }
    }
}