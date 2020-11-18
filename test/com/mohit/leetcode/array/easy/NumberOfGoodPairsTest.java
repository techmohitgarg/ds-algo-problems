package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfGoodPairsTest {
    NumberOfGoodPairs object = null;

    int[] testInput1 = {1,2,3,1,1,3};
    int[] testInput2 = {1,1,1,1};
    int[] testInput3 = {1, 2, 3};

    @Before
    public void setUp() throws Exception {
        this.object = new NumberOfGoodPairs();
    }

    @Test
    public void baseTest() {
        Assert.assertEquals(0, object.numIdenticalPairs(new int[]{}));
    }

    @Test
    public void numIdenticalPairs1() {
        Assert.assertEquals(4, object.numIdenticalPairs(testInput1));
    }
    @Test
    public void numIdenticalPairs2() {
        Assert.assertEquals(6, object.numIdenticalPairs(testInput2));
    }
    @Test
    public void numIdenticalPairs3() {
        Assert.assertEquals(0, object.numIdenticalPairs(testInput3));
    }


}