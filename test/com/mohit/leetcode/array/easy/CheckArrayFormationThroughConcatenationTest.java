package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CheckArrayFormationThroughConcatenationTest {

    private CheckArrayFormationThroughConcatenation object;

    @Before
    public void setUp() throws Exception {
        object = new CheckArrayFormationThroughConcatenation();
    }

    @Test
    public void canFormArray1() {
        Assert.assertEquals(true, object.canFormArray(new int[]{85}, new int[][]{{85}}));
    }

    @Test
    public void canFormArray2() {
        Assert.assertEquals(true, object.canFormArray(new int[]{15, 88}, new int[][]{{88}, {15}}));
    }

    @Test
    public void canFormArray3() {
        Assert.assertEquals(false, object.canFormArray(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}));
    }

    @Test
    public void canFormArray4() {
        Assert.assertEquals(true, object.canFormArray(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}));
    }

    @Test
    public void canFormArray5() {
        Assert.assertEquals(false, object.canFormArray(new int[]{1, 3, 5, 7}, new int[][]{{2, 4, 6, 8}}));
    }
}
