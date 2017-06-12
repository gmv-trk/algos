package com.algos.dynamicprogramming;

import java.util.HashMap;

/*
 * How many ways you can make change for a given sum and set of coins
 * Incomplete
 */
public class CoinChange {
    
    private static HashMap<String, Integer> sumWays = new HashMap<>();
    
    private static int findWays(int sum, int[] coins, int index, String seq){
        if(index > (coins.length-1) || sum < 0){
            return 0;
        }
        
        if(sumWays.containsKey(sum+"-"+index)){
            return sumWays.get(sum+"-"+index);
        }
        
        if(sum == coins[index]){
            System.out.println("Seq "+seq+"->"+coins[index]);
            return 1;
        }


        int ways = findWays(sum, coins, index+1, seq) +
                findWays(sum-coins[index], coins, index, seq+"->"+coins[index]);
        sumWays.put(sum+"-"+index, ways);
        return ways;
    }
    
    public static void main(String[] args) {
        int[] coins = {1, 2, 3, 4};
        int sum = 5;
        System.out.println("No. of ways to make change "+findWays(sum, coins, 0, ""));
//        System.out.println("No. of ways to make change "+findWays(sum, coins));
    }
}
