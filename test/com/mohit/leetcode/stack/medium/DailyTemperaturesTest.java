package com.mohit.leetcode.stack.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DailyTemperaturesTest {
    DailyTemperatures object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new DailyTemperatures();
    }

    @Test
    public void dailyTemperatures() {
        int[][] testIupts = {{73, 74, 75, 71, 69, 72, 76, 73}};
        int[][] expected = {{1, 1, 4, 2, 1, 1, 0, 0}};
        for (int i = 0; i < testIupts.length; i++) {
            int[] output = object.dailyTemperatures(testIupts[i]);
            compare(expected[i], output);
        }
    }

    private void compare(int[] expected, int[] output) {
        assertTrue("Arrays not the same length", expected.length == output.length);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], output[i]);
    }
}