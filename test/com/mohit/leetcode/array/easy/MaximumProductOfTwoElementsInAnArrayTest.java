package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MaximumProductOfTwoElementsInAnArrayTest {
    MaximumProductOfTwoElementsInAnArray object = null;

    @Before
    public void setUp() throws Exception {
        object = new MaximumProductOfTwoElementsInAnArray();
    }

    @Test
    public void maxProduct1() {
        Assert.assertEquals(12, object.maxProduct(new int[]{3, 4, 5, 2}));
    }
    @Test
    public void maxProduct2() {
        Assert.assertEquals(16, object.maxProduct(new int[]{1,5,4,5}));
    }
    @Test
    public void maxProduct3() {
        Assert.assertEquals(12, object.maxProduct(new int[]{3,7}));
    }

}
