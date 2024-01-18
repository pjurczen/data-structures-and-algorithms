package com.pjurczen;

public class QuickSort {

    public void quickSort(int[] input, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(input, low, high);
            quickSort(input, low, partitionIndex - 1);
            quickSort(input, partitionIndex + 1, high);
        }
    }

    private int partition(int[] input, int low, int high) {
        int pivot = input[high];
        int i = low - 1;
        for (int j=low; j <= high - 1; j++) {
            if (input[j] < pivot) {
                i++;
                swap(input, i, j);
            }
        }
        swap(input, i + 1, high);
        return i + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
