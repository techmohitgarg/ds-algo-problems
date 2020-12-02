package com.mohit.leetcode.array.easy;

import com.mohit.leetcode.stack.medium.AsteroidCollision;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RunningSumOfArrayTest {
    RunningSumOfArray object = null;

    int[] testInput1 = {1, 2, 3, 4}, testExpectOutput1 = {1, 3, 6, 10};
    int[] testInput2 = {1,1,1,1,1}, testExpectOutput2 = {1,2,3,4,5};
    int[] testInput3 = {3,1,2,10,1}, testExpectOutput3 = {3,4,6,16,17};

    @Before
    public void setUp() throws Exception {
        this.object = new RunningSumOfArray();
    }

    @Test
    public void runningSum() {
        Assert.assertArrayEquals(testExpectOutput1, object.runningSum(testInput1));
        Assert.assertArrayEquals(testExpectOutput2, object.runningSum(testInput2));
        Assert.assertArrayEquals(testExpectOutput3, object.runningSum(testInput3));
    }


}