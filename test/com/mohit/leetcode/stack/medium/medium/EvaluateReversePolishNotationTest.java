package com.mohit.leetcode.stack.medium.medium;

import com.mohit.leetcode.stack.medium.EvaluateReversePolishNotation;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {
    EvaluateReversePolishNotation object;

    @Before
    public void setUp() {
        this.object = new EvaluateReversePolishNotation();
    }

    @Test
    public void evalRPN() {
        Assert.assertEquals(9, object.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        Assert.assertEquals(6, object.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        Assert.assertEquals(22, object.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
