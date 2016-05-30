package com.prinkipia.examples;

import java.util.LinkedList;

public class MovingAverage {
    LinkedList<Integer> queue;
    int size;

    /**
     * Initialize your data structure here.
     */
    public MovingAverage(int size) {
        this.queue = new LinkedList<Integer>();
        this.size = size;
    }

    public double next(int val) {
        // add item to end of list
        queue.offer(val);
        // if list is bigger than size, remove first (oldest item)
        if (queue.size() > this.size) {
            queue.poll();
        }
        int sum = 0;
        for (int i : queue) {
            sum = sum + i;
        }

        // compute average
        return (double) sum / queue.size();
    }

    public static void main(String[] args) {
        MovingAverage movingAverage = new MovingAverage(4);
        System.out.println(movingAverage.next(1));
        System.out.println(movingAverage.next(2));
        System.out.println(movingAverage.next(3));
        System.out.println(movingAverage.next(4));
        System.out.println(movingAverage.next(5));
        System.out.println(movingAverage.next(6));
        System.out.println(movingAverage.next(7));
        System.out.println(movingAverage.next(8));
    }
}