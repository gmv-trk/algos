package com.algos.dynamicprogramming;

/*
 * Objec­tive: Given a rope of length n meters, write an algo­rithm to cut the rope in such a way that prod­uct of dif­fer­ent lengths of rope is max­i­mum. 
 * At least one cut has to be made.

Note: Assume that the length of rope is more than 2 meters, since at least one cut has to be made.
 */
public class MaximumProductCutting {
    public void maxProductCutting(int n) {
        int[] MPC = new int[n + 1];
        MPC[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            int mp = Integer.MIN_VALUE;
            for (int j = 1; j < i; j++) {
                mp = Math.max(mp, Math.max(j * MPC[i - j], j * (i - j)));
            }
            MPC[i] = mp;
        }
        System.out.println("Dynamic Programming: Maximum product cutting in "
                + n + "is " + MPC[n]);
    }

    public static void main(String[] args) throws java.lang.Exception {
        MaximumProductCutting i = new MaximumProductCutting();
        i.maxProductCutting(10);
    }
}

/*
 * Recursive
 * If stored becomes memoization
 public int maxProdutRecursion(int n) {
    // base case
    if (n == 0 || n == 1) {
        return 0;
    }
    // make all possible cuts and get the maximum
    int max = 0;
    for (int i = 1; i < n; i++) {
        // Either this cut will produce the max product OR
        // we need to make further cuts
        max = Math.max(max,
                Math.max(i * (n - i), i * maxProdutRecursion(n - i)));
    }
    //return the max of all
    return max;
}
 */
