package com.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * Print first non repeating character in a stream of characters
 * Can be done as below. 
 */
public class CharStreamNonRepeat {
//    private static Queue q = new Queue();
    private static int[] index = new int[256];
    private static int[] count = new int[256];
    public static void main(String[] args) throws IOException {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(in);
         int c = br.read();
        while(c != -1){
//            char character = (char) c;
            System.out.println(c);
            int pos = c %256;
            count[pos] = count[pos]++;
            
            printFirstNonRepeat();
            c = br.read();
        }
    }

    private static int printFirstNonRepeat() {
        int minIndex = Integer.MAX_VALUE;
        int character = Integer.MAX_VALUE;
        for(int i=0; i< count.length; i++){
            if(count[i] == 1 && minIndex > index[i]){
                minIndex = index[i];
                character = i;
            }
        }
        System.out.println("minIndex "+minIndex+" ; characterArrayIndex "+character);
        return minIndex;
    }
}


