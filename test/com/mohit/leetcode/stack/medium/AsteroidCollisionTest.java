package com.mohit.leetcode.stack.medium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AsteroidCollisionTest {
    AsteroidCollision object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new AsteroidCollision();
    }

    @Test
    public void asteroidCollision() {
        int[][] testIupts = {{5, 10, -5}, {8, -8}, {10, 2, -5}, {-2, -1, 1, 2}};
        int[][] expected = {{5, 10}, {}, {10}, {-2, -1, 1, 2}};
        for (int i = 0; i < testIupts.length; i++) {
            int[] output = object.asteroidCollision(testIupts[i]);
            compare(expected[i], output);
        }
    }


    private void compare(int[] expected, int[] output) {
        assertTrue("Arrays not the same length", expected.length == expected.length);
        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], output[i]);
    }
}