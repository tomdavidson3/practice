package com.prinkipia.examples;

import java.util.Arrays;

public class CountArrayInversions {
    public static void main(String[] args) {
        int[] a = { 45, 23, 11, 89, 77, 98, 4, 28, 65, 43 };

        mergeSort(a);

        System.out.println(Arrays.toString(a));
    }

    static int mergeSort(int[] a) {
        return countInversions(a, new int[a.length], 0, a.length - 1);
    }

    static int countInversions(int[] a, int[] tmp, int left, int right) {
        int x = 0;
        int y = 0;
        int z = 0;

        if (left < right) {
            int center = (left + right) / 2;
            x = countInversions(a, tmp, left, center);
            y = countInversions(a, tmp, center + 1, right);
            z = mergeAndCountSplitInversions(a, tmp, left, center, right);
        }

        return x + y + z;
    }

    private static int mergeAndCountSplitInversions(int[] array, int[] tempMergArr, int left, int middle, int right) {
        int count = 0;

        for (int i = left; i <= right; i++) {
            tempMergArr[i] = array[i];
        }
        int i = left;
        int j = middle + 1;
        int k = left;
        while (i <= middle && j <= right) {
            if (tempMergArr[i] <= tempMergArr[j]) {
                array[k] = tempMergArr[i];
                i++;
            }
            else {
                array[k] = tempMergArr[j];
                j++;
            }
            k++;
        }
        while (i <= middle) {
            array[k] = tempMergArr[i];
            k++;
            i++;
        }

        return count;
    }
}
