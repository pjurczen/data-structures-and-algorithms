package com.pjurczen;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int[][] tmp = new int[intervals.length][2]; // intervals[0].length
        int left = intervals[0][0];
        int right = intervals[0][1];
        int intervalResultsCounter = 0;
        for (int i=1; i < intervals.length; i++) {
            int leftCandidate = intervals[i][0];
            int rightCandidate = intervals[i][1];
            if (left > leftCandidate) {
                left = leftCandidate;
                right = Math.max(right, rightCandidate);
            } else if (right >= leftCandidate) {
                    right = rightCandidate;
            } else {
                tmp[intervalResultsCounter][0] = left;
                tmp[intervalResultsCounter][1] = right;
                left = leftCandidate;
                right = rightCandidate;
                intervalResultsCounter++;
            }
        }
        tmp[intervalResultsCounter][0] = left;
        tmp[intervalResultsCounter][1] = right;
        int[][] result = new int[intervalResultsCounter + 1][2];
        for (int i = 0; i < intervalResultsCounter + 1; i++) {
            result[i] = tmp[i];
        }
        return result;
    }
}
