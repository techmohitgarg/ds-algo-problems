package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CreateTargetArrayInTheGivenOrderTest {
    CreateTargetArrayInTheGivenOrder object = null;

    int[] testInput1 = {0, 1, 2, 3, 4}, testInput1_ = {0, 1, 2, 2, 1}, testExpectOutput1 = {0, 4, 1, 3, 2};
    int[] testInput2 = {1, 2, 3, 4, 0}, testInput2_ = {0, 1, 2, 3, 0}, testExpectOutput2 = {0, 1, 2, 3, 4};
    int[] testInput3 = {1}, testInput3_ = {0}, testExpectOutput3 = {1};

    @Before
    public void setUp() throws Exception {
        this.object = new CreateTargetArrayInTheGivenOrder();
    }

    @Test
    public void createTargetArray1() {
        Assert.assertArrayEquals(testExpectOutput1, object.createTargetArray(testInput1, testInput1_));
    }

    @Test
    public void createTargetArray2() {
        Assert.assertArrayEquals(testExpectOutput2, object.createTargetArray(testInput2, testInput2_));
    }

    @Test
    public void createTargetArray3() {
        Assert.assertArrayEquals(testExpectOutput3, object.createTargetArray(testInput3, testInput3_));
    }
}
