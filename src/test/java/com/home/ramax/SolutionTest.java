package com.home.ramax;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SolutionTest {

    @Test
    public void test_simple() {
        List<String> list = List.of("cat", "dog", "god", "tca");
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 3));
        expected.add(List.of(1, 2));

        List<List<Integer>> actual = new Solution().anagrams(list);

        assertTwoRes(expected, actual);
    }

    @Test
    public void test_duplicates_simple() {
        List<String> list = List.of("cat", "dog", "dog", "cat");
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 3));
        expected.add(List.of(1, 2));

        List<List<Integer>> actual = new Solution().anagrams(list);

        assertTwoRes(expected, actual);
    }

    @Test
    public void test_not_simple() {
        List<String> list = List.of("caat", "dog", "godd", "taca", "aact", "ddd", "xxx");
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 3, 4));

        List<List<Integer>> actual = new Solution().anagrams(list);

        assertTwoRes(expected, actual);
    }

    @Test
    public void test_hard() {
        List<String> list = List.of("caat", "dog", "godd", "taca", "aact", "oddg", "xxx");
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 3, 4));
        expected.add(List.of(2, 5));

        List<List<Integer>> actual = new Solution().anagrams(list);

        assertTwoRes(expected, actual);
    }

    @Test
    public void test_duplicate_hard() {
        List<String> list = List.of("caat", "dog", "godd", "taca", "aact", "oddg", "dog", "xxx", "caat");
        List<List<Integer>> expected = new ArrayList<>();
        expected.add(List.of(0, 3, 4, 8));
        expected.add(List.of(1, 6));
        expected.add(List.of(2, 5));

        List<List<Integer>> actual = new Solution().anagrams(list);

        assertTwoRes(expected, actual);
    }

    @Test
    public void test_empty() {
        List<String> list = List.of();
        List<List<Integer>> expected = new ArrayList<>();

        List<List<Integer>> actual = new Solution().anagrams(list);

        assertTwoRes(expected, actual);
    }

    private void assertTwoRes(List<List<Integer>> expected, List<List<Integer>> actual) {
        Assertions.assertEquals(expected.size(), actual.size());

        int i = 0;
        while (i < expected.size()) {
            List<Integer> expectedGroup = expected.get(i);
            List<Integer> actualGroup = actual.get(i);

            Assertions.assertEquals(expectedGroup.size(), actualGroup.size());

            int j = 0;
            while (j < expectedGroup.size()) {
                Assertions.assertEquals(expectedGroup.get(j), actualGroup.get(j));

                j++;
            }

            i++;
        }
    }
}
