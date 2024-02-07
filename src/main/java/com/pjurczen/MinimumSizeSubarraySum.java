package com.pjurczen;

public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        return solveNLogN(target, nums);
    }

    private int solveN(int target, int[] nums) {
        int bestResult = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;
        for (; right < nums.length; right++) {
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

    private int solveNLogN(int s, int[] nums) {
        var sums = new int[nums.length + 1];
        sums[0] = 0;
        int bestCount = Integer.MAX_VALUE;
        for (int i=1; i <= nums.length; i++) {
            sums[i] = sums[i-1] + nums[i-1];
        }
        for (int i=0; i < nums.length; i++) {
            int endIndex = binarySearch(sums, i+1, nums.length, s + sums[i]);
            if (endIndex == -1) {
                break;
            }
            var count = endIndex - i;
            if (count < bestCount) {
                bestCount = count;
            }
        }
        return bestCount == Integer.MAX_VALUE ? 0 : bestCount;
    }

    private int binarySearch(int[] sums, int start, int end, int target) {
        if (end - start < 1) {
            return sums[start] >= target ? start : -1;
        }
        var pivot = start + (end - start) / 2;
        var left = binarySearch(sums, start, pivot, target);
        if (left != -1) {
            return left;
        }
        return binarySearch(sums, pivot + 1, end, target);
    }
}
