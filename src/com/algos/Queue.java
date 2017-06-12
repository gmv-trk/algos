package com.algos;

class LLNode {
    public LLNode next;
    public int value;
    public LLNode previous;
}

public class Queue {
    private LLNode head = null;
    private LLNode tail = null;
    public int pop(){
        if(tail != null){
            LLNode node = tail;
            tail = node.previous;
            if(tail != null){
                tail.next = null;
            }
            int c = node.value;
            node = null;
            return c;
        }
        return 0;
    }
    public void push(int c){
        LLNode node = new LLNode();
        node.value = c;
        node.next = null;
        if(head == null){
            head = node;
            tail = node;
        }else{
            node.previous = tail;
            tail.next = node;
            tail = tail.next;
        }
    }
}
