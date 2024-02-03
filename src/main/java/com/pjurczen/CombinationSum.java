package com.pjurczen;

import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        var result = new ArrayList<List<Integer>>();
        var stack = new Stack<Integer>();
        backtrack(candidates, target, 0, 0, result, stack);
        return result;
    }

    private void backtrack(int[] candidates, int target, int i, int sum, List<List<Integer>> result, Stack<Integer> stack) {
        if (i == candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<>(stack));
        } else {
            for (int j = i; j < candidates.length; j++) {
                stack.push(candidates[j]);
                backtrack(candidates, target, j, sum+candidates[j], result, stack);
                stack.pop();
            }
        }
    }
}
