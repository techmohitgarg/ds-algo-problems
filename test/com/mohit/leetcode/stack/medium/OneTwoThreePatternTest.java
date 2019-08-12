package com.mohit.leetcode.stack.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OneTwoThreePatternTest {
    OneTwoThreePattern object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new OneTwoThreePattern();
    }

    @Test
    public void find132pattern() {
        Assert.assertEquals(false, object.find132pattern(new int[]{1, 2, 3, 4}));
        Assert.assertEquals(true, object.find132pattern(new int[]{3, 1, 4, 2}));
        Assert.assertEquals(true, object.find132pattern(new int[]{-1, 3, 2, 0}));
        Assert.assertEquals(false, object.find132pattern(new int[]{1, 2, 0}));
        Assert.assertEquals(true, object.find132pattern(new int[]{0, 2, 1}));
        Assert.assertEquals(true, object.find132pattern(new int[]{-2, 1, 2, -2, 1, 2}));
    }
}