package com.algos.dynamicprogramming;

/*
 * Find paths from top left to right bottom
 */
public class MatrixPath {
    private static int rows = 4;
    private static int columns = 4;
    private static int[][] matrix = new int[rows][columns]; 
    private static int[][] ways = new int[rows][columns];
    private static int[][] minWts = new int[rows][columns];
    private static int[][] maxlength = new int[rows][columns];

    private static int findPathCount(int row, int col){
        if((row > (rows-1)) || (col > (columns-1)) || (matrix[row][col] == -1)){
            return 0;
        }
        if(row == rows-1 && col == columns-1){
            return 1;
        }
        if(ways[row][col] != -1 ){
            return ways[row][col];
        }
        
        int paths =  findPathCount(row+1, col) + findPathCount(row, col+1);
        ways[row][col] = paths;
        return paths;
    }
    
    private static int findMinWeight(int row, int col){
        if((row > (rows-1)) || (col > (columns-1)) || matrix[row][col] == -1){
            return Integer.MAX_VALUE;
        }
        if(row == rows-1 && col == columns-1){
            return matrix[row][col];
        }
        if(minWts[row][col] != -1){
            return minWts[row][col];
        }
        int minWeight = matrix[row][col]+Math.min(findMinWeight(row+1, col), findMinWeight(row, col+1));
        minWts[row][col] = minWeight;
        return minWeight;
    }
    
    private static int largestSnakeSeq(int row, int col){
        if((row > (rows-1)) || (col > (columns-1))){
            return Integer.MIN_VALUE;
        }
        if(row == rows-1 && col == columns-1){
            return matrix[row][col];
        }
        if(maxlength[row][col] != -1){
            return maxlength[row][col];
        }
        int down = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        if((matrix[row+1][col] - matrix[row][col]) == Math.abs(1)){
            down = largestSnakeSeq(row+1, col);
        }
        if ((matrix[row][col+1] - matrix[row][col]) == Math.abs(1)) {
            right = largestSnakeSeq(row, col+1);
        }
        int maxLength = 1+Math.max(down , right);
        maxlength[row][col] = maxLength;
        return maxLength;
    }
    
    public static void main(String[] args) {
        
        for(int row = 0; row < rows; row++){
            for(int col =0; col < columns; col++){
                matrix[row][col] = row+col;
                System.out.print(matrix[row][col]+" ");
                ways[row][col] = -1;
                minWts[row][col] = -1;
                maxlength[row][col] = -1;
            }
            System.out.println();
        }
        System.out.println("Ways to reach from top left to right bottom "+findPathCount(0,0));
        System.out.println("Min weight path "+findMinWeight(0,0));
        System.out.println("Largest Snake path "+largestSnakeSeq(0,0));
    }
}
