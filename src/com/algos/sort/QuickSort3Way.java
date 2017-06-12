package com.algos.sort;

/*
 * Efficient sort when duplicate keys are present. 
 * Dutch national flag problem
 */

public class QuickSort3Way {
    private static int[] arr = {4, 3, 2, 1, 3, 2, 1, 5, 12};
    
    private static void sort(int low, int high){
        if(high<low){
            return;
        }
        int lt=low;
        int i=low+1;
        int gt=high;
        while(i <=gt ){
            if(arr[i] < arr[lt]){
                swap(i, lt);
                lt++;
            }else if(arr[i] > arr[lt]){
                swap(i, gt);
                gt--;
            }else{
                i++;
            }
        }        
        sort(low, lt-1);
        sort(gt+1, high);
    }
    
    private static void swap(int i,int j){
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    
    public static void main(String[] args) {
        sort(0, arr.length-1);
        for(int i : arr){
            System.out.print(i+"\t");
        }
    }
}
