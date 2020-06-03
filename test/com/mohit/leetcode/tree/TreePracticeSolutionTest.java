package com.mohit.leetcode.tree;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TreePracticeSolutionTest {
    TreePracticeSolution sol = null;

    @Before
    public void setUp() throws Exception {
        sol = new TreePracticeSolution();
    }

    @Test
    public void findTarget() {
        Assert.assertEquals(false, sol.findTarget(MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]"), 21));
    }

    @Test
    public void tree2str() {
        Assert.assertEquals("1(2(4))(3)", sol.tree2str(MakeTree.stringToTreeNode("[1,2,3,4]")));
        Assert.assertEquals("1(2()(4))(3)", sol.tree2str(MakeTree.stringToTreeNode("[1,2,3,null,4]")));
    }

}