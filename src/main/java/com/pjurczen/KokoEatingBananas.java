package com.pjurczen;

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int i=0; i < piles.length; i++) {
            maxVal = Math.max(maxVal, piles[i]);
        }
        int start = 1;
        int end = maxVal;
        int best = Integer.MAX_VALUE;
        while (start <= end) {
            int middle = start + (end - start) / 2;
            int count = count(piles, middle);
            if (count > h) {
                start = middle + 1;
            } else if (count <= h) {
                best = Math.min(best, middle);
                end = middle - 1;
            }
        }
        return best;
    }

    private int count(int[] piles, int step) {
        int count = 0;
        for (int j=0; j < piles.length; j++) {
            int val = piles[j];
            count += Math.ceil((double) val / step);
        }
        return count;
    }
}
