package com.prinkipia.examples;

import java.util.Arrays;

public class RotateMatrix {
    public static void rotate90(int[][] matrix) {
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;

                int top = matrix[first][i];

                matrix[first][i] = matrix[last - offset][first];
                matrix[last - offset][first] = matrix[last][last - offset];
                matrix[last][last - offset] = matrix[i][last];
                matrix[i][last] = top;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][] {
                new int[] { 1, 2, 3 },
                new int[] { 4, 5, 6 },
                new int[] { 7, 8, 9 }
        };

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        rotate90(matrix);

        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }
}
