package com.mohit.leetcode.stack.medium;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidateStackSequencesTest {
    ValidateStackSequences object = null;

    @Before
    public void setUp() throws Exception {
        object = new ValidateStackSequences();
    }

    @Test
    public void validateStackSequences() {
        int[][] testpushIuputs = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {2, 1, 0}, {5, 10, 15, 2, 1}};
        int[][] testpopIuputs = {{4, 5, 3, 2, 1}, {4, 3, 5, 1, 2}, {1, 2, 0}, {2, 1, 15, 10, 5}};
        boolean[] testInputsExpectedOutputs = {true, false, true, true};
        for (int i = 0; i < testpushIuputs.length; i++) {
            assertTrue(String.format("Test Case %d OutPut Not Matched", i), testInputsExpectedOutputs[i]
                    == object.validateStackSequences(testpushIuputs[i], testpopIuputs[i]));
        }
    }

    private void compare(int[] expected, int[] output) {

        for (int i = 0; i < expected.length; i++)
            assertEquals(expected[i], output[i]);
    }

}