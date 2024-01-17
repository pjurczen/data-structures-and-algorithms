package com.pjurczen;

public class HashTable {

    public static void main(String[] args) {
        final var input = "mystringtohashnow";

        final var hashTable = new int[26];

        for (int i=0; i < input.length(); i++) {
            hashTable[input.charAt(i) - 'a']++;
        }

        System.out.println("Count of character 'o':" + hashTable['o' - 'a']);
    }
}
