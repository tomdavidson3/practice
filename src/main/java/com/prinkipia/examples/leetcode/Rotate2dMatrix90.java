package com.prinkipia.examples.leetcode;

public class Rotate2dMatrix90 {
    void rotate(int[][] matrix) {
        int n = matrix.length;
        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // flip columns
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] test = new int[][] {
                { 1, 2 },
                { 3, 4 }
        };

        new Rotate2dMatrix90().rotate(test);
    }
}
