package com.prinkipia.examples;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FindHeaviestCoin {
    private static class Balance {
        static int weigh(List<Integer> left, List<Integer> right) {
            return weighStack(left) - weighStack(right);
        }

        private static int weighStack(List<Integer> weights) {
            int sum = 0;
            for (int weight : weights) {
                sum += weight;
            }
            return sum;
        }
    }

    // we can divide the coins into three stacks. The left and right stacks will have the same number of coins.
    // By weighing the stacks against each other on the balance we can determine which of the stacks has the heaviest
    // coin. We then use recursion to find the heaviest coin in the stack with the heaviest coin
    //
    static int findCoin(List<Integer> coins) {
        if (coins == null) {
            throw new IllegalArgumentException("coins can't be null");
        }
        if (coins.isEmpty()) {
            throw new IllegalArgumentException("coins can't be empty");
        }

        if (coins.size() == 1) {
            return coins.get(0);
        }

        int oneThird = coins.size() / 3;
        List<Integer> leftStack = coins.subList(0, oneThird);
        List<Integer> rightStack = coins.subList(oneThird, 2 * oneThird);
        List<Integer> remainingStack = coins.subList(2 * oneThird, coins.size());

        int diff = Balance.weigh(leftStack, rightStack);
        if (Balance.weigh(leftStack, rightStack) > 0) {
            return findCoin(leftStack);
        }
        else if (diff < 0) {
            return findCoin(rightStack);
        }
        else {
            return findCoin(remainingStack);
        }
    }

    public static void main(String[] args) {
        List<Integer> coins = Arrays.asList(1,1,22,1,1,1,1,1,1,1,1);

        // print the weight of the heaviest coin
        System.out.println(findCoin(coins));

        coins = Arrays.asList(1,1,1,1,1,1,1,1,1,1,1);
        System.out.println(findCoin(coins));

        try {
            coins = Collections.emptyList();
            System.out.println(findCoin(coins));
        }
        catch (Exception e) {
            // this is expected
        }

        try {
            System.out.println(findCoin(null));
        }
        catch (Exception e) {
            // this is expected

        }
    }
}
