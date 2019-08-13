package com.mohit.leetcode.stack.medium;

import com.mohit.leetcode.stack.medium.RemoveKDigits;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveKDigitsTest {
    RemoveKDigits object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new RemoveKDigits();
    }

    @Test
    public void removeKdigits() {
        Assert.assertEquals("1219", object.removeKdigits("1432219", 3));
        Assert.assertEquals("200", object.removeKdigits("10200", 1));
        Assert.assertEquals("0", object.removeKdigits("10", 2));
        Assert.assertEquals("0", object.removeKdigits("9", 1));
        Assert.assertEquals("11", object.removeKdigits("112", 1));
        Assert.assertEquals("0", object.removeKdigits("", 1));
    }
}