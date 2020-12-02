package com.mohit.leetcode.array.easy;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CountNegativeNumbersInASortedMatrixTest {

    CountNegativeNumbersInASortedMatrix object = null;

    @Before
    public void setUp() throws Exception {
        object = new CountNegativeNumbersInASortedMatrix();
    }

    @Test
    public void countNegatives1() {
        Assert.assertEquals(8, object.countNegatives(new int[][]{{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}}));
    }
    @Test
    public void countNegatives2() {
        Assert.assertEquals(0, object.countNegatives(new int[][]{{3,2}, {1,0}}));
    }
    @Test
    public void countNegatives3() {
        Assert.assertEquals(3, object.countNegatives(new int[][]{{1,-1}, {-1,-1}}));
    }
    @Test
    public void countNegatives4() {
        Assert.assertEquals(1, object.countNegatives(new int[][]{{-1}}));
    }
}
