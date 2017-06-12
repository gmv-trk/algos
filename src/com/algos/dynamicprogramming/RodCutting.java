package com.algos.dynamicprogramming;

/*
 * Cost corresponding to each size is given
 * Index of array is size, value is cost
 * Find count & sizes of rods to be cut to attain max cost for a specified length of rod.
 */

public class RodCutting {

    private static int[] rodsize;
    public static int profitDP(int[] value, int length) {
        int[] solution = new int[length + 1];
        solution[0] = 0;

        for (int i = 1; i <= length; i++) {
            int max = -1;
            for (int j = 0; j <= i; j++) {
                if(max < (value[j] + solution[i - j])){
                    rodsize[i] = j;
                }
                max = Math.max(max, value[j] + solution[i - j]); 
                solution[i] = max;
            }
        }
        return solution[length];
    }

    public static void main(String[] args) {
        int[] value = {0, 2, 3, 7, 8, 9 };
        int len = 5;
        rodsize = new int[len+1];
        System.out.println("Max profit for length is " + len + ":"
                + profitDP(value, len));
        int i = len;
        while(i > 0){
            System.out.println(rodsize[i]);
            i = i - rodsize[i];
        }

    }

}
