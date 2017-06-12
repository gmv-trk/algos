package com.algos.dynamicprogramming;

/*
 * int[] A = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
 * length of LIS is 7 and LIS is {1, 12, 23, 52, 61, 69, 70}.
 */
public class LongestIncreasingSubsequence {
    
    private static void findLIS(int[] arr){
        int[] LIS = new int[arr.length];
        int globalMax = Integer.MIN_VALUE;
        int maxEndIndex = -1;
        //loop for LIS of length i
        for(int i=0; i<arr.length; i++){
            //loop to get max so far
            int max = Integer.MIN_VALUE;
            for(int j=0; j<i; j++){
                if(arr[j] < arr[i]){
                    if(max < (LIS[j]+1)){
                        max = LIS[j]+1;
                    }
                }
            }
            if(max == Integer.MIN_VALUE){
                //No such j where j<i
                max = 1;
            }
            LIS[i] = max;
            if(globalMax < LIS[i]){
                globalMax = LIS[i];
                maxEndIndex = i;
            }
        }
        System.out.println("LIS value "+globalMax+ ". End index "+maxEndIndex);
        for(int i : LIS){
            System.out.print(i+" ");
        }
        System.out.println();
        //print the sequence
        String seq = "";
        int lisSize = globalMax;
        for(int i=maxEndIndex; i>=0; i-- ){
            if(LIS[i] == lisSize){
                seq+=arr[i]+" ";
                lisSize--;
            }
        }
        System.out.println("Max length increasing sequence in reverse order \n"+seq);
        
    }
    
    public static void main(String[] args) {
        int[] arr = { 1, 12, 7, 0, 23, 11, 52, 31, 61, 69, 70, 2 };
        findLIS(arr);
    }

}
