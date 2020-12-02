package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FindNumbersWithEvenNumberOfDigitsTest {
    FindNumbersWithEvenNumberOfDigits object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new FindNumbersWithEvenNumberOfDigits();
    }

    @Test
    public void findNumbers1() {
        Assert.assertEquals(2, object.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    @Test
    public void findNumbers2() {
        Assert.assertEquals(1, object.findNumbers(new int[]{555, 901, 482, 1771}));
    }

}
