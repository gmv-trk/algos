package com.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

/*
 * How many different ways can you make change for an amount, given a list of coins? 
 * sum = 4, types of coins 1,2,3 -> 4 ways {1,1,1,1},{1,1,2},{2,2},{1,3}
 * sum = 10, types of coins 2,5,3,6 -> 5 ways {2,2,2,2,2},{2,2,3,3},{2,2,6},{2,3,5},{5,5}
 */
public class CoinChange {
    private static int[] set = null;
    private static Set<String> ways = new HashSet<String>();

    public static void main(String[] args) {
        Scanner scan = null;
        try {
            System.out.println("Input sum:");
            scan = new Scanner(System.in);
            int sum = scan.nextInt();
            System.out.println("Space separated list of numbers Ex: 1 2 3 4");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String numbers = br.readLine();
            String[] numbersArr = numbers.split("\\s+");
            System.out.println("Length of array "+numbersArr.length);
            set = new int[numbersArr.length];
            for (int index = 0; index < numbersArr.length; index++) {
                set[index] = Integer.parseInt(numbersArr[index]);
            }
            System.out.println(findIfSubsetSum(sum, numbersArr.length - 1, "")+" Ways : "+ways.size());
            for(String way : ways){
                System.out.println(way);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }

    private static boolean findIfSubsetSum(int sum, int n, String seq) {
        if(sum == 0){
            //Got sum
//            System.out.println("Final Sequence "+seq);
            ways.add(seq);
            return true;
        }else if(sum > 0 && n == -1){
            // Sum not found in set
            return false;
        } else if(set[n] > sum){
            return findIfSubsetSum(sum, n-1, seq);
        } else {
            boolean out1 = findIfSubsetSum(sum-set[n], n, seq+set[n]+"->");
            boolean out2 = findIfSubsetSum(sum-set[n], n-1, seq+set[n]+"->");
            boolean out3 = findIfSubsetSum(sum, n-1, seq);
            /*if(out1 || out2){
                System.out.print(set[n]+"->");
            }*/
            return (out1 || out2 || out3); 
        }
    }
}
