package com.algos.arrayslists;

/*
 * Reverse alternative K nodes in a LL
 */
public class ReverseKLL {
    private static Node head = null, tail = null;
    
    /*
     * 1->2->3->4
     */
    private static void reverseLLIterative(){
        Node prev = null;
        Node current = head;
        while(current != null){
           Node newcurrent = current.next;
           current.next = prev;
           prev = current;
           current = newcurrent;
        }
        head = prev;
    }
    
    /*
     * 1->2->3->4
     */
    private static Node reverseLLRecursive(Node node){
        if(node == null || node.next == null){
            return node;
        }
        Node newhead = reverseLLRecursive(node.next);
        node.next.next = node;
        node.next = null;
        return newhead;
    }
    
    // 1->2->3->4 to 2->1->3->4
    private static void swapAdjacent2(){
        if(head == null || head.next == null){
            return;
        }
        Node node1 = head;    
        head = head.next;
        Node prev = null;
        while(node1 !=null && node1.next != null){
            Node node2 = node1.next;
            node1.next = node2.next;
            node2.next = node1;
            if(prev != null){
                prev.next = node2;
            }
            prev = node1;
            node1 = node1.next;            
        }
    }
    
    /*
     * Incomplete
     */
    private static void reverseAlternateKIterative(int k){
        Node current = head;
        Node prevk = null;
        Node prev = null;
        int count = k;
        Node startk = head;
        boolean oddCycle = true;
        while( current != null){
            if(count==0){
                oddCycle = !oddCycle;
                count = k;
                System.out.println("After one cycle ");
                printLL();
            }
            if(oddCycle){
                if(count == k){
                    startk = current;
                }
                Node newcurrent = current.next;
                current.next = prev;
                prev = current;
                current = newcurrent;
                if(count == 1){
                    //end of reversal
                    prev.next = prevk; 
                    startk.next = newcurrent;
                    if(prevk == null){
                        //1st cycle
                        head = prev;
                    }
                    /*if(prevk != null){
                        prevk.next = prev;
                    }
                    startk.next = newcurrent;
                    prevk = prev;*/
                }
            }else{
                
                if(count == 1){
                    prevk = current;
                    prev = current;
                }
                current = current.next;
                
            }
            count--;
        }
    }
    
    private static void reverseAlternateK(int k){
        //reverse 1-k, 2k+1 - 3k etc
        int start = 1, end = k;
        boolean oddCycle = true;
        Node current = head;
        Node prev = null;
        while(current != null){
            if(oddCycle){
                Node newStart = reverseKFromStart(current, k);
                current.next = newStart.next;
                prev.next = newStart;
                prev = current;
            }else{
                current = current.next;
            }
            k--;
        }
    }
    
    private static Node reverseKFromStart(Node current, int k){
        while(k == 1 || current.next == null ){
            return current;
        }
        Node newStart = reverseKFromStart(current.next, k--);
        current.next.next = current;
        current.next = null;
        return newStart;
    }
    
    private static void printLL(){
        Node pointer = head;
        while (pointer != null){
            System.out.print(pointer.value+" ");
            pointer = pointer.next;
        }
    }
    
    public static void main(String[] args) {
        
        //Build LL
        for(int i=0; i<20 ; i++){
            
            if(head == null){
                head = new Node(i);
                tail = head;
            }else{
                tail.next = new Node(i);
                tail = tail.next;
            }
        }  
        System.out.println("Original LL :");
        printLL();
        reverseLLIterative();
        System.out.println("\nAfter Iterative reversal :");
        printLL();
        head = reverseLLRecursive(head);
        System.out.println("\nAfter Recursive reversal :");
        printLL();
        swapAdjacent2();
        System.out.println("\nAfter Swapping Adjacent 2 :");
        printLL();
        swapAdjacent2();
        System.out.println("\nAfter Swapping Adjacent 2 Again :");
        printLL();
        reverseAlternateKIterative(3);
        printLL();
    }
    
}
class Node {
    public Node next;
    public int value;
    public Node(int i){
        next = null;
        this.value = i;
    }
    public String toString(){
        return "NodeVal : "+value+" ; Node.Next : "+next.value;
    }
}