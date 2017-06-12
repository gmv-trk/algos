package com.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 * Find if subset of given numbers(single occurance) for a specified sum. 
 */
public class SubsetSingleOccuranceSum {
    private static int[] set = null;

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
            System.out.println(findIfSubsetSum(sum, numbersArr.length - 1));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            scan.close();
        }
    }

    private static boolean findIfSubsetSum(int sum, int n) {
        if(sum == 0){
            //Got sum
            System.out.println("");
            return true;
        }else if(sum > 0 && n == -1){
            // Sum not found in set
            return false;
        } else if(set[n] > sum){
            return findIfSubsetSum(sum, n-1);
        } else {
            boolean out1 = findIfSubsetSum(sum-set[n], n-1);
            boolean out2 = findIfSubsetSum(sum, n-1);
            if(out1){
                System.out.print(set[n]+"->");
            }
            return (out1 || out2); 
        }
    }

}
