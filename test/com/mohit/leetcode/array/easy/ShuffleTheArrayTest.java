package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ShuffleTheArrayTest {
    ShuffleTheArray object = null;

    int[] testInput1 = {2, 5, 1, 3, 4, 7}, testExpectOutput1 = {2, 3, 5, 4, 1, 7};
    int n1 = 3;
    int[] testInput2 = {1, 2, 3, 4, 4, 3, 2, 1}, testExpectOutput2 = {1, 4, 2, 3, 3, 2, 4, 1};
    int n2 = 4;
    int[] testInput3 = {1, 1, 2, 2}, testExpectOutput3 = {1, 2, 1, 2};
    int n3 = 2;

    @Before
    public void setUp() throws Exception {
        this.object = new ShuffleTheArray();
    }

    @Test
    public void baseTest() {
        Assert.assertArrayEquals(new int[]{}, object.shuffle(new int[]{}, 0));
        Assert.assertArrayEquals(new int[]{1, 2}, object.shuffle(new int[]{1, 2}, 1));
    }

    @Test
    public void shuffle1() {
        Assert.assertArrayEquals(testExpectOutput1, object.shuffle(testInput1, n1));
    }
    @Test
    public void shuffle2() {
        Assert.assertArrayEquals(testExpectOutput2, object.shuffle(testInput2, n2));
    }
    @Test
    public void shuffle3() {
        Assert.assertArrayEquals(testExpectOutput3, object.shuffle(testInput3, n3));
    }


}