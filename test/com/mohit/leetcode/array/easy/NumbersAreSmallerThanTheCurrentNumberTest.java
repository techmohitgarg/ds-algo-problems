package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumbersAreSmallerThanTheCurrentNumberTest {
    NumbersAreSmallerThanTheCurrentNumber object;

    int[] testInput1 = {8, 1, 2, 2, 3}, testExpectOutput1 = {4, 0, 1, 1, 3};
    int[] testInput2 = {6, 5, 4, 8}, testExpectOutput2 = {2, 1, 0, 3};
    int[] testInput3 = {7, 7, 7, 7}, testExpectOutput3 = {0, 0, 0, 0};


    @Before
    public void setUp() throws Exception {
        this.object = new NumbersAreSmallerThanTheCurrentNumber();
    }


    @Test
    public void baseTest() {
        Assert.assertArrayEquals(new int[]{}, object.smallerNumbersThanCurrent(new int[]{}));
    }

    @Test
    public void smallerNumbersThanCurrent1() {
        Assert.assertArrayEquals(testExpectOutput1, object.smallerNumbersThanCurrent(testInput1));
    }

    @Test
    public void smallerNumbersThanCurrent2() {
        Assert.assertArrayEquals(testExpectOutput2, object.smallerNumbersThanCurrent(testInput2));
    }

    @Test
    public void smallerNumbersThanCurrent3() {
        Assert.assertArrayEquals(testExpectOutput3, object.smallerNumbersThanCurrent(testInput3));
    }

}
