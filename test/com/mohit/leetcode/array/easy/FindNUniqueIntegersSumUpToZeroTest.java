package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindNUniqueIntegersSumUpToZeroTest {
    FindNUniqueIntegersSumUpToZero object = null;

    @Before
    public void setUp() throws Exception {
        object = new FindNUniqueIntegersSumUpToZero();
    }

    @Test
    public void sumZero1() {
        int[] result = object.sumZero(5);

        Assert.assertEquals(true, checkIfSumZero(result));
        setIfDuplicateNum(result);
    }

    @Test
    public void sumZero2() {
        int[] result = object.sumZero(3);

        Assert.assertEquals(true, checkIfSumZero(result));
        setIfDuplicateNum(result);
    }

    @Test
    public void sumZero3() {
        int[] result = object.sumZero(1);

        Assert.assertEquals(true, checkIfSumZero(result));
        setIfDuplicateNum(result);
    }


    private boolean checkIfSumZero(int[] result) {
        int sum = 0;
        for (int i = 0; i < result.length; i++) {
            sum += result[i];
        }
        return sum == 0;
    }

    private void setIfDuplicateNum(int[] result) {
        Set<Integer> set = new HashSet<>();
        for (int val : result) {
            if (!set.add(val)) {
                Assert.fail();
            }
        }
    }
}
