package com.mohit.leetcode.stack.medium.medium;

import com.mohit.leetcode.stack.medium.DecodeString;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DecodeStringTest {
    DecodeString object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new DecodeString();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void decodeString() {
        Assert.assertEquals("aaabcbc", object.decodeString("3[a]2[bc]"));
        Assert.assertEquals("accaccacc", object.decodeString("3[a2[c]]"));
        Assert.assertEquals("abcabccdcdcdef", object.decodeString("2[abc]3[cd]ef"));
    }
}