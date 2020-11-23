package com.mohit.leetcode.array.easy;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SumOfAllOddLengthSubArraysTest {
    SumOfAllOddLengthSubArrays object = null;

    int[] testInput1 = {1, 4, 2, 5, 3};
    int expectedOutPut1 = 58;
    int[] testInput2 = {1, 2};
    int expectedOutPut2 = 3;
    int[] testInput3 = {10, 11, 12};
    int expectedOutPut3 = 66;

    @Before
    public void setUp() throws Exception {
        this.object = new SumOfAllOddLengthSubArrays();
    }

    @Test
    public void testSumOddLengthSubArrays1() {
        Assert.assertEquals(expectedOutPut1, object.sumOddLengthSubarrays(testInput1));
    }

    @Test
    public void testSumOddLengthSubArrays2() {
        Assert.assertEquals(expectedOutPut2, object.sumOddLengthSubarrays(testInput2));
    }

    @Test
    public void testSumOddLengthSubArrays3() {
        Assert.assertEquals(expectedOutPut3, object.sumOddLengthSubarrays(testInput3));
    }
}