package com.mohit.leetcode.array.easy;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class XOROperationInAnArrayTest {
    XOROperationInAnArray object = null;

    @Before
    public void setUp() throws Exception {
        this.object = new XOROperationInAnArray();
    }

    @Test
    public void xorOperation1() {
        Assert.assertEquals(8, object.xorOperation(5, 0));
    }

    @Test
    public void xorOperation2() {
        Assert.assertEquals(8, object.xorOperation(4, 3));
    }

    @Test
    public void xorOperation3() {
        Assert.assertEquals(7, object.xorOperation(1, 7));
    }


    @Test
    public void xorOperation4() {
        Assert.assertEquals(2, object.xorOperation(10, 5));
    }
}
