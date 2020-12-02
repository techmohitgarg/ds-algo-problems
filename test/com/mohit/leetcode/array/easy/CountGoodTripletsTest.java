package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountGoodTripletsTest {
    CountGoodTriplets object;

    @Before
    public void setUp() throws Exception {
        object = new CountGoodTriplets();
    }

    @Test
    public void countGoodTriplets1() {
        Assert.assertEquals(4, object.countGoodTriplets(new int[]{3, 0, 1, 1, 9, 7}, 7, 2, 3));
    }

    @Test
    public void countGoodTriplets2() {
        Assert.assertEquals(0, object.countGoodTriplets(new int[]{1, 1, 2, 2, 3}, 0, 0, 1));
    }
    @Test
    public void countGoodTriplets3() {
        Assert.assertEquals(12, object.countGoodTriplets(new int[]{7,3,7,3,12,1,12,2,3}, 5, 8, 1));
    }
}
