package com.pjurczen;

public class Array<T> {
    public static void main(String[] args) {

        var lastIndex = 0;
        final var array = new String[5];
        array[lastIndex] = "test";
        lastIndex++;
        array[lastIndex] = "test1";
        lastIndex++;

        printArray(array);
        System.out.println(lastIndex);
    }

    private static void printArray(String[] array) {
        final StringBuilder stringBuilder = new StringBuilder();
        for (int i=0; i < array.length; i++) {
            if (i < array.length - 1) {
                stringBuilder.append(array[i] +", ");
            } else {
                stringBuilder.append(array[i]);
            }
        }
        System.out.println(stringBuilder.toString());
    }
}
