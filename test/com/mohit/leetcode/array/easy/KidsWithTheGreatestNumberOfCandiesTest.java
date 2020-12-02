package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KidsWithTheGreatestNumberOfCandiesTest {
    KidsWithTheGreatestNumberOfCandies object = null;

    int[] testInput1 = {2, 3, 5, 1, 3};
    int extraCandies1 = 3;
    Boolean[] expectedResult1_ = {true, true, true, false, true};
    List<Boolean> expectedResult1 = Arrays.asList(expectedResult1_);

    int[] testInput2 = {4, 2, 1, 1, 2};
    int extraCandies2 = 1;
    Boolean[] expectedResult2_ = {true, false, false, false, false};
    List<Boolean> expectedResult2 = Arrays.asList(expectedResult2_);

    int[] testInput3 = {12, 1, 12};
    int extraCandies3 = 10;
    Boolean[] expectedResult3_ = {true, false, true};
    List<Boolean> expectedResult3 = Arrays.asList(expectedResult3_);

    @Before
    public void setUp() throws Exception {
        this.object = new KidsWithTheGreatestNumberOfCandies();
    }

    @Test
    public void baseTest() {
        Assert.assertEquals(new ArrayList<>(), object.kidsWithCandies(new int[]{}, 0));
    }

    @Test
    public void kidsWithCandies1() {
        Assert.assertEquals(expectedResult1, object.kidsWithCandies(testInput1, extraCandies1));
    }

    @Test
    public void kidsWithCandies2() {
        Assert.assertEquals(expectedResult2, object.kidsWithCandies(testInput2, extraCandies2));
    }

    @Test
    public void kidsWithCandies3() {
        Assert.assertEquals(expectedResult3, object.kidsWithCandies(testInput3, extraCandies3));
    }


}