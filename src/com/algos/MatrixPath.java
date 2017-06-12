package com.algos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1) Find all possible paths to traverse from one corner to opp corner. 
 * 2) Cells have weights. Find paths and corresponding weights as well 
 * Only down and right are allowed and few cells are blocked (marked -1 in matrix)
 * Assuming [0,0] & [n-1,n-1] are not blocked
 */
public class MatrixPath {
    private static int[][] matrix = null; 
    private static int count =0;
    public static void main(String[] args) throws IOException {
        System.out.println("Input matrix rows and columns Ex: 3 2 for 3x2");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rowCol = br.readLine().split("\\s+");
        int rows = Integer.parseInt(rowCol[0]);
        int cols = Integer.parseInt(rowCol[1]);
        matrix = new int[rows][cols];
        for(int i=0; i<rows; i++){
            System.out.println("Input columns of row. Ex 10 12 13"+i);
            String[] vals= br.readLine().split("\\s+");
            for(int j=0; j< cols; j++){
                matrix[i][j] = Integer.parseInt(vals[j]);
            }
        }
        System.out.println("Printing Matrix..");
        for(int i=0; i<rows; i++){
            for(int j=0; j< cols; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.print("\n");
        }
        traverse(0,0,"", matrix[0][0]);    
        System.out.println("Ways - "+count);
    }
    private static void traverse(int rowStart, int colStart, String seq, int weight) {
        if(rowStart+1 < matrix.length && matrix[rowStart+1][colStart] == -1 && colStart+1 < matrix[0].length && matrix[rowStart][colStart+1] == -1){
            System.out.println("No route from here");
            return;
        }
        if(rowStart == matrix.length-1 && colStart == matrix[0].length-1){
            count++;
            System.out.println("Reached Destination. Printing path. D for down, R for right");
            System.out.println("Weight : "+weight+"; Moves : "+seq);
            return;
        }
        
        if(rowStart+1 < matrix.length && matrix[rowStart+1][colStart] != -1){
            traverse(rowStart+1, colStart, seq+"-D", weight + matrix[rowStart+1][colStart]);
        }
        if(colStart+1 < matrix[0].length && matrix[rowStart][colStart+1] != -1){
            traverse(rowStart, colStart+1, seq+"-R", weight + matrix[rowStart][colStart+1]);
        }
    }
}
