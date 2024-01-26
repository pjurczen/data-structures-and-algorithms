package com.pjurczen;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int bestResult = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        for ( ;right < nums.length; right++) {
            sum += nums[right];
            count++;
            if (sum >= target) {
                bestResult = Math.min(count, bestResult);
            }
            while (sum >= target) {
                sum -= nums[left];
                count--;
                if (sum >= target) {
                    bestResult = Math.min(count, bestResult);
                }
                left++;
            }
        }
        if (bestResult == Integer.MAX_VALUE) {
            return 0;
        }
        return bestResult;
    }
}
