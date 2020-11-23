package com.mohit.leetcode.array.easy;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStreamTest {
    OrderedStream object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new OrderedStream(5);
    }

    @Test
    public void testSumOddLengthSubArrays1() {

        List<String> test1 = object.insert(3, "ccccc");
        List<String> test2 = object.insert(1, "aaaaa");
        List<String> test3 = object.insert(2, "bbbbb");
        List<String> test4 = object.insert(5, "eeeee");
        List<String> test5 = object.insert(4, "ddddd");

        List<String> expectedOutPutBlank = new ArrayList<>();

        Assert.assertEquals(expectedOutPutBlank, test1);
        Assert.assertEquals(Arrays.asList(new String[]{"aaaaa"}), test2);
        Assert.assertEquals(Arrays.asList(new String[]{"bbbbb", "ccccc"}), test3);
        Assert.assertEquals(expectedOutPutBlank, test4);
        Assert.assertEquals(Arrays.asList(new String[]{"ddddd", "eeeee"}), test5);
    }

}