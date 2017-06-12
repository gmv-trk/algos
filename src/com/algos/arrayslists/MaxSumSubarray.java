package com.algos.arrayslists;

/*
 * Kadane's algo
 * max sum subarray problem
 * int [] A = {−2, 1, −3, 4, −1, 2, 1, −5, 4};
 * Output: contiguous subarray with the largest sum is 4, −1, 2, 1, with sum 6.
 * 
 */
public class MaxSumSubarray {
    public static void main(String[] args) {
        int [] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int max_global = arr[0];
        int max_end_here = arr[0];
        for(int i=1; i< arr.length; i++){
            max_end_here = Math.max(arr[i], max_end_here+arr[i]);
            max_global = Math.max(max_global, max_end_here);
        }
        System.out.println("Max sum "+max_global);
    }
    
    //Other approach
    public int solve(int [] a){
        int [] solution = new int[a.length+1];
        solution[0] = 0;

        for (int j = 1; j <solution.length ; j++) {
            solution[j] = Math.max(solution[j-1]+a[j-1],a[j-1]);
        }
        //this will print the solution matrix
        //System.out.println(Arrays.toString(solution));
        //now return the maximum in the solution array
        int result = solution[0];
        for (int j = 1; j <solution.length ; j++) {
            if(result<solution[j])
                result = solution[j];
        }

        return result;
    }
}
