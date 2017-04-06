package com.prinkipia.examples;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] a = {45,23,11,89,77,98,4,28,65,43};

        mergeSort(a);

        System.out.println(Arrays.toString(a));
    }

    static void mergeSort(int[] a) {
        mergeSort(a, new int[a.length], 0, a.length - 1);
    }

    static void mergeSort(int[] a, int[] tmp, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmp, left, center);
            mergeSort(a, tmp, center + 1, right);
            merge(a, tmp, left, center, right);
        }
    }

    private static void merge(int[] array, int[] tempMergArr, int left, int middle, int right) {

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
            } else {
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
    }
}
