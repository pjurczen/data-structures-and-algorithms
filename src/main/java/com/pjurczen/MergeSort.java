package com.pjurczen;

public class MergeSort {

    public void sort(int[] input, int l, int r) {
        if (l < r) {
            int pivot = l + (r - l) / 2;
            sort(input, l, pivot);
            sort(input, pivot + 1, r);
            merge(input, l, pivot, r);
        }
    }

    private void merge(int[] input, int l, int pivot, int r) {
        int n1 = pivot - l + 1;
        int n2 = r - pivot;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for (int i=0; i < n1; i++) {
            left[i] = input[l+i];
        }
        for (int i=0; i < n2; i++) {
            right[i] = input[pivot+1+i];
        }
        int i = 0,j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                input[k] = left[i];
                i++;
            } else {
                input[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            input[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            input[k] = right[j];
            j++;
            k++;
        }
    }
}
