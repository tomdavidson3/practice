package com.prinkipia.examples.stanford;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianMaintence {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new FileInputStream(args[0]));

        PriorityQueue<Integer> hHigh = new PriorityQueue<>();
        PriorityQueue<Integer> hLow = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(final Integer o1, final Integer o2) {
                return o2 - o1;
            }
        });

        int k = 0;

        int first = scanner.nextInt();
        int second = scanner.nextInt();

        k += 2;

        if (first < second) {
            hHigh.add(second);
            hLow.add(first);
        }
        else {
            hHigh.add(first);
            hLow.add(second);
        }

        long sum = 0;
        while (scanner.hasNext()) {
            k++;

            int n = scanner.nextInt();

            Integer loMedian = hLow.peek();

            if (n < loMedian) {
                hLow.add(n);
            }
            else {
                hHigh.add(n);
            }

            if (Math.abs(hLow.size() - hHigh.size()) > 1) {
                if (hLow.size() > hHigh.size()) {
                    hHigh.add(hLow.poll());
                }
                else {
                    hLow.add(hHigh.poll());
                }
            }

            int median = findMedian(hLow, hHigh, k);
            sum += median;
        }
        System.out.println(sum % 10000);
    }

    private static int findMedian(final PriorityQueue<Integer> hLow, final PriorityQueue<Integer> hHigh, final int k) {
        if (hLow.size() == hHigh.size()) {
            if (k % 2 == 1) {
                return hHigh.peek();
            }
            else {
                return hLow.peek();
            }
        }
        else if (hLow.size() > hHigh.size()) {
            return hLow.peek();
        }
        else {
            return hHigh.peek();
        }
    }
}
