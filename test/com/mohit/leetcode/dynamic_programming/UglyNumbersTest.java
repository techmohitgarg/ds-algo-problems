package com.mohit.leetcode.dynamic_programming;

import com.mohit.greeksofgreeks.dynamic_programming.UglyNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class UglyNumbersTest {
    UglyNumbers object = null;

    @Before
    public void setUp() throws Exception {
        object = new UglyNumbers();
    }

    @Test
    public void nthUglyNumber1() {
        Assert.assertEquals(8, object.getNthUglyNo(7));
    }

    @Test
    public void nthUglyNumber2() {
        Assert.assertEquals(12, object.getNthUglyNo(10));
    }

    @Test
    public void nthUglyNumber3() {
        Assert.assertEquals(24, object.getNthUglyNo(15));
    }

    @Test
    public void nthUglyNumber4() {
        Assert.assertEquals(5832, object.getNthUglyNo(150));
    }

}
