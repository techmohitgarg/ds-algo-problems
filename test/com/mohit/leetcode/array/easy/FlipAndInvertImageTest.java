package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FlipAndInvertImageTest {
    FlipAndInvertImage object = null;

    @Before
    public void setUp() throws Exception {
        object = new FlipAndInvertImage();
    }

    @Test
    public void flipAndInvertImage1() {
        Assert.assertArrayEquals(new int[][]{{1, 0, 0}, {0, 1, 0}, {1, 1, 1}},
                object.flipAndInvertImage(new int[][]{{1, 1, 0}, {1, 0, 1}, {0, 0, 0}}));

    }

    @Test
    public void flipAndInvertImage2() {
        Assert.assertArrayEquals(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}},
                object.flipAndInvertImage(new int[][]{{1, 1, 0, 0}, {0, 1, 1, 0}, {0, 0, 0, 1}, {1, 0, 1, 0}}));

    }
}
