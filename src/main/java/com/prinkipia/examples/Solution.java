package com.prinkipia.examples;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        boolean first = true;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target && first) {
                result[0] = i;
                result[1] = i;
                first = false;
            } else if (nums[i] == target) {
                result[1] = i;
            }
        }

        return result;
    }
}