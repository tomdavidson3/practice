package com.prinkipia.examples;

import java.util.HashMap;
import java.util.Map;

public class TwoSums {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i + 1;
                result[0] = map.get(target - numbers[i]);
                return result;
            }
            map.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        TwoSums twoSums = new TwoSums();
        int[] testCase = new int[] { 3, 2, 4 };
        twoSums.twoSum(testCase, 6);
    }
}
