package com.algos.dynamicprogramming;

/*
 *  Given a matrix of 0’s and 1’s (binary matrix). Find out Max­i­mum size square sub-matrix with all 1’s.
 */
public class MaxSquareSubmatrix {

    public void subMatrix(int[][] arrA, int row, int cols) {
        int[][] sub = new int[row][cols];
        // copy the first row
        for (int i = 0; i < cols; i++) {
            sub[0][i] = arrA[0][i];
        }
        // copy the first column
        for (int i = 0; i < row; i++) {
            sub[i][0] = arrA[i][0];
        }

        // for rest of the matrix
        // check if arrA[i][j]==1
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < cols; j++) {
                if (arrA[i][j] == 1) {
                    sub[i][j] = Math.min(sub[i - 1][j - 1],
                            Math.min(sub[i][j - 1], sub[i - 1][j])) + 1;
                } else {
                    sub[i][j] = 0;
                }
            }
        }
        // find the maximum size of sub matrix
        int maxSize = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < cols; j++) {
                if (sub[i][j] > maxSize) {
                    maxSize = sub[i][j];
                }
            }
        }
        System.out.println("Maximum size square sub-matrix with all 1s: " + maxSize);
    }
    public static void main(String[] args) {
        int[][] arrA = { { 0, 1, 0, 1, 0, 1 }, { 1, 0, 1, 0, 1, 0 },
                { 0, 1, 1, 1, 1, 0 }, { 0, 0, 1, 1, 1, 0 },
                { 1, 1, 1, 1, 1, 1 } };
        MaxSquareSubmatrix i = new MaxSquareSubmatrix();
        i.subMatrix(arrA, 5, 6);
    }
}