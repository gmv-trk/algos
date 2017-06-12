package com.algos;

import java.io.*;

/*
 * Given a sequence of 0s and 1s like 01010010, find no.of combinations of 01 (0 coming first, 1 in subsequent indexes-need not be continuous)
 */
public class Combinations01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        int zeros = 0;
        int combinations = 0;
       line = br.readLine();
        String[] strarr = line.split("\\s+");
        for(int i = 0; i < strarr.length; i++){
            if("0".equals(strarr[i])){
                zeros++;
            }else{
                combinations=combinations+zeros;
            }
        }
            
        
        System.out.println("No.of combinations of 01 are "+combinations);
        
    }
}
