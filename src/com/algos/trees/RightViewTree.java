package com.algos.trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Build a is binary tree. Print Right, Left, Top & Bottom views of tree
 * Incomplete
 */
public class RightViewTree {
    private static LLNode root = null;
    public static void main(String[] args) throws IOException {
        buildBinaryTree();
        printRightView();
        printLeftView();
    }

    /*
     * Prepare a level order traversal Array of LinkedLists and print last Node of LinkedList for each index in array
     */
    private static void printRightView() {
        LLNode node = root;
        while(node !=null){
            
        }
    }
    
    /*
     * Prepare a level order traversal Array of LinkedLists and print First Node of LinkedList for each index in array
     */
    private static void printLeftView() {
        LLNode node = root;
        while(node !=null){
            
        }
    }

    private static void buildBinaryTree() throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
        String numbers = br.readLine();
        String[] arr = numbers.split("\\s+");
        for(int i=0; i< arr.length; i++){
            addToBinarySearchTree(Integer.parseInt(arr[i]));
        }
    }

    /*
     * Assuming previous is left, next is right
     */
    private static void addToBinarySearchTree(int val) {
        if(root == null){
            root = new LLNode();
            root.value = val;
        }else{
            LLNode node = root;
            while(node.right != null){
                if(node.value > val){
                    if(node.left != null){
                        node = node.left;
                    }else{
                        LLNode newNode = new LLNode();
                        newNode.value = val;
                        newNode.right = node;
                        node.left = newNode; 
                        break;
                    }
                    
                }else{
                    if(node.right != null){
                        node = node.right;
                    }else{
                        LLNode newNode = new LLNode();
                        newNode.value = val;
                        newNode.left = node;
                        node.right = newNode; 
                        break;
                    }
                }
            }            
        }
        
    }
}

class LLNode {
    public LLNode right;
    public int value;
    public LLNode left;
}
