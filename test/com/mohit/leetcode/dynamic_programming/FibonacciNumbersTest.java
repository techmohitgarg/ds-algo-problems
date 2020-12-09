package com.mohit.leetcode.dynamic_programming;

import com.mohit.greeksofgreeks.dynamic_programming.FibonacciNumbers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FibonacciNumbersTest {
    FibonacciNumbers object = null;

    @Before
    public void setUp() throws Exception {
        object = new FibonacciNumbers();
    }

    @Test
    public void fib() {
        for (int i = 0; i < 10; i++) {
            int fib1 = object.fib(i);
            int fib2 = object.fibonacciNum(i);
            if (fib1 != fib2)
                Assert.fail("Output mis-matched for " + i);
        }
    }
}
