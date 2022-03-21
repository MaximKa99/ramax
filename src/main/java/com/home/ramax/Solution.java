package com.home.ramax;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {
    public List<List<Integer>> anagrams(final List<String> A) {
        List<Wrapper> res = new ArrayList<>();

        int i = 0;
        while (i < A.size()) {
            Wrapper wrapper = new Wrapper(A.get(i), new ArrayList<>());

            int index = res.indexOf(wrapper);
            if (index >= 0) {
                res.get(index).addIndex(i);
            } else {
                wrapper.addIndex(i);
                res.add(wrapper);
            }

            i++;
        }

        return res.stream().filter(Wrapper::thereIsAnagrams).map(elem -> elem.indexes).collect(Collectors.toList());
    }

    private boolean isAnagram(String one, String two) {
        Map<Character, Integer> oneMap = new HashMap<>();
        Map<Character, Integer> twoMap = new HashMap<>();

        for (char c : one.toCharArray()) {
            oneMap.put(c, oneMap.getOrDefault(c, 0) + 1);
        }

        for (char c : two.toCharArray()) {
            twoMap.put(c, twoMap.getOrDefault(c, 0) + 1);
        }

        if (oneMap.keySet().size() != twoMap.keySet().size()) {
            return false;
        }

        for (Map.Entry<Character, Integer> entry : oneMap.entrySet()) {
            if (!twoMap.containsKey(entry.getKey())) {
                return false;
            }

            if (twoMap.get(entry.getKey()).equals(entry.getValue())) {
                return false;
            }
        }

        return true;
    }

    private static class Wrapper {
        public String str;
        public List<Integer> indexes;

        public Wrapper(String str, List<Integer> indexes) {
            this.str = str;
            this.indexes = indexes;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Wrapper) {
                Map<Character, Integer> oneMap = new HashMap<>();
                Map<Character, Integer> twoMap = new HashMap<>();

                for (char c : this.str.toCharArray()) {
                    oneMap.put(c, oneMap.getOrDefault(c, 0) + 1);
                }

                for (char c : ((Wrapper) obj).str.toCharArray()) {
                    twoMap.put(c, twoMap.getOrDefault(c, 0) + 1);
                }

                if (oneMap.keySet().size() != twoMap.keySet().size()) {
                    return false;
                }

                for (Map.Entry<Character, Integer> entry : oneMap.entrySet()) {
                    if (!twoMap.containsKey(entry.getKey())) {
                        return false;
                    }

                    if (!twoMap.get(entry.getKey()).equals(entry.getValue())) {
                        return false;
                    }
                }

                return true;
            }

            return false;
        }

        public void addIndex(int index) {
            indexes.add(index);
        }

        public boolean thereIsAnagrams() {
            return indexes.size() > 1;
        }
    }

    private static class StringProxy {
        public String str;

        public StringProxy(String str) {
            this.str = str;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof StringProxy) {
                Map<Character, Integer> oneMap = new HashMap<>();
                Map<Character, Integer> twoMap = new HashMap<>();

                for (char c : this.str.toCharArray()) {
                    oneMap.put(c, oneMap.getOrDefault(c, 0) + 1);
                }

                for (char c : ((StringProxy) obj).str.toCharArray()) {
                    twoMap.put(c, twoMap.getOrDefault(c, 0) + 1);
                }

                if (oneMap.keySet().size() != twoMap.keySet().size()) {
                    return false;
                }

                for (Map.Entry<Character, Integer> entry : oneMap.entrySet()) {
                    if (!twoMap.containsKey(entry.getKey())) {
                        return false;
                    }

                    if (twoMap.get(entry.getKey()).equals(entry.getValue())) {
                        return false;
                    }
                }

                return true;
            }

            return false;
        }
    }
}
