package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NumberOfStudentsDoingHomeworkAtGivenTimeTest {
    NumberOfStudentsDoingHomeworkAtGivenTime object = null;

    @Before
    public void setUp() throws Exception {
        object = new NumberOfStudentsDoingHomeworkAtGivenTime();
    }

    @Test
    public void busyStudent1() {
        Assert.assertEquals(1, object.busyStudent(new int[]{1, 2, 3}, new int[]{3, 2, 7}, 4));
    }

    @Test
    public void busyStudent2() {
        Assert.assertEquals(1, object.busyStudent(new int[]{4}, new int[]{4}, 4));
    }

    @Test
    public void busyStudent3() {
        Assert.assertEquals(0, object.busyStudent(new int[]{4}, new int[]{4}, 5));
    }

    @Test
    public void busyStudent4() {
        Assert.assertEquals(0, object.busyStudent(new int[]{1, 1, 1, 1}, new int[]{1, 3, 2, 4}, 7));
    }

    @Test
    public void busyStudent5() {
        Assert.assertEquals(5, object.busyStudent(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10}, 5));
    }
}
