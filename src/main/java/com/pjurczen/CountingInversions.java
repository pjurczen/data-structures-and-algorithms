package com.pjurczen;

import java.util.Arrays;

import static com.pjurczen.CountingInversions.SortedArrayWithInversions.sortedArrayWithInversions;

public class CountingInversions {

    public SortedArrayWithInversions sortAndCountInv(int[] A) {
        if (A.length == 1) {
            return sortedArrayWithInversions(A, 0);
        }
        final var firstHalf = Arrays.copyOfRange(A, 0, A.length/2);
        final var secondHalf = Arrays.copyOfRange(A, A.length/2, A.length);
        final var B = sortAndCountInv(firstHalf);
        final var C = sortAndCountInv(secondHalf);
        final var D = mergeAndCountSplitInv(B.sortedArray, C.sortedArray);
        return sortedArrayWithInversions(D.sortedArray, B.inversionsCount + C.inversionsCount + D.inversionsCount);
    }

    private SortedArrayWithInversions mergeAndCountSplitInv(int[] B, int[] C) {
        final int[] output = new int[B.length + C.length];
        int i=0, j=0;
        int k = 0;
        int inversionsCount = 0;
        while (i < B.length && j < C.length) {
            if (B[i] <= C[j]) {
                output[k] = B[i];
                i++;
            } else {
                output[k] = C[j];
                j++;
                inversionsCount += B.length - i;
            }
            k++;
        }
        while (i < B.length) {
            output[k] = B[i];
            i++;
            k++;
        }
        while (j < C.length) {
            output[k] = C[j];
            j++;
            k++;
        }
        return sortedArrayWithInversions(output, inversionsCount);
    }

    public static class SortedArrayWithInversions {
        public int[] sortedArray;
        public int inversionsCount;

        private SortedArrayWithInversions(int[] sortedArray, int inversionsCount) {
            this.sortedArray = sortedArray;
            this.inversionsCount = inversionsCount;
        }

        public static SortedArrayWithInversions sortedArrayWithInversions(int[] sortedArray, int inversionsCount) {
            return new SortedArrayWithInversions(sortedArray, inversionsCount);
        }
    }
}
