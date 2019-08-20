package com.mohit.leetcode.stack.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MinimumAddtoMakeParenthesesValidTest {
    MinimumAddtoMakeParenthesesValid object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new MinimumAddtoMakeParenthesesValid();
    }

    @Test
    public void minAddToMakeValid() {
        assertEquals(1, object.minAddToMakeValid("())"));
        assertEquals(3, object.minAddToMakeValid("((("));
        assertEquals(0, object.minAddToMakeValid("()"));
        assertEquals(4, object.minAddToMakeValid("()))(("));
        assertEquals(3, object.minAddToMakeValid("()())(("));
    }
}