package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MinimumTimeVisitingAllPointsTest {
    MinimumTimeVisitingAllPoints object = null;

    @Before
    public void setUp() throws Exception {
        object = new MinimumTimeVisitingAllPoints();
    }

    @Test
    public void minTimeToVisitAllPoints1() {
        Assert.assertEquals(7, object.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}}));
    }

    @Test
    public void minTimeToVisitAllPoints2() {
        Assert.assertEquals(5, object.minTimeToVisitAllPoints(new int[][]{{3, 2}, {-2, 2}}));
    }

    @Test
    public void minTimeToVisitAllPoints3() {
        Assert.assertEquals(11, object.minTimeToVisitAllPoints(new int[][]{{1, 1}, {3, 4}, {-1, 0}, {-2, -4}}));
    }
}
