package com.pjurczen;

public class CountOnes {

    public int countOnes(int n) {
        var count = 0;
        while (n > 0) {
            n = n & (n-1);
            count++;
        }
        return count;
    }
}
