package com.prinkipia.examples;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Long, Long> cached = new HashMap<>();

    public static long fibonacci(long n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        if (cached.containsKey(n)) {
            return cached.get(n);
        }
        else {
            long f = fibonacci(n - 1) + fibonacci(n - 2);
            cached.put(n, f);
            return f;
        }
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(500));
    }
}
