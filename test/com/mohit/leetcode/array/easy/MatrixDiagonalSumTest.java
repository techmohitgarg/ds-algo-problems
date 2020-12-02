package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MatrixDiagonalSumTest {
    MatrixDiagonalSum object = null;

    @Before
    public void setUp() throws Exception {
        object = new MatrixDiagonalSum();
    }

    @Test
    public void diagonalSum1() {
        Assert.assertEquals(25, object.diagonalSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
    }

    @Test
    public void diagonalSum2() {
        Assert.assertEquals(8, object.diagonalSum(new int[][]{{1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}}));
    }

    @Test
    public void diagonalSum3() {
        Assert.assertEquals(5, object.diagonalSum(new int[][]{{5}}));
    }

}
