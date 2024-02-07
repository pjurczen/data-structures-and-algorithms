package com.pjurczen;

import java.util.*;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        var groups = new HashMap<Key, List<String>>();
        for (String str : strs) {
            var key = new Key(str);
            if (groups.containsKey(key)) {
                groups.get(key).add(str);
            } else {
                var list = new ArrayList<String>();
                list.add(str);
                groups.put(key, list);
            }
        }
        return groups.values().stream().toList();
    }

    public static class Key {
        public String sortedString;

        public Key(String str) {
            var chars = str.toCharArray();
            Arrays.sort(chars);
            this.sortedString = new String(chars);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == null) {
                return false;
            }
            if (!(obj instanceof Key)) {
                return false;
            }
            var other = (Key) obj;
            return Objects.equals(other.sortedString, this.sortedString);
        }

        @Override
        public int hashCode() {
            return sortedString.hashCode();
        }

        @Override
        public String toString() {
            return sortedString;
        }
    }
}
