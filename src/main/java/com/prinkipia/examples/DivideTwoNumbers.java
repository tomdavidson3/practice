package com.prinkipia.examples;

/**
 * Created by Tom on 5/29/2016.
 */
public class DivideTwoNumbers {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }

        if (dividend == 0) {
            return 0;
        }

        if (divisor == 1) {
            return dividend;
        }

        if (divisor == 2) {
            return dividend >> 1;
        }

        if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return -dividend;
            }
        }

        int remainder = Math.abs(dividend);
        int decrementValue = Math.abs(divisor);
        int count = 0;
        while (remainder >= decrementValue) {
            remainder -= decrementValue;
            if (remainder < 0) {
                return Integer.MAX_VALUE;
            }
            count++;
        }
        if (dividend < 0 && divisor < 0) {
            return count;
        }
        if (dividend > 0 && divisor > 0) {
            return count;
        }

        return -count;
    }

    public static void main(String[] args) {
        DivideTwoNumbers solution = new DivideTwoNumbers();
        System.out.println(solution.divide(-1685665565, -1259882199));
    }
}
