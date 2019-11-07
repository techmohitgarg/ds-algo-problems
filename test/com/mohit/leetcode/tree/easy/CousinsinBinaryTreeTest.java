package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CousinsinBinaryTreeTest {
    CousinsinBinaryTree binaryTree = null;

    @Before
    public void setUp() throws Exception {
        binaryTree = new CousinsinBinaryTree();
    }

    @Test
    public void isCousins() {
        Assert.assertEquals(false, binaryTree.isCousins(MakeTree.stringToTreeNode("[1,2,3,4]"), 4, 3));
        Assert.assertEquals(true, binaryTree.isCousins(MakeTree.stringToTreeNode("[1,2,3,null,4,null,5]"), 5, 4));
        Assert.assertEquals(false, binaryTree.isCousins(MakeTree.stringToTreeNode("[1,2,3,null,4]"), 2, 3));
        Assert.assertEquals(false, binaryTree.isCousins(MakeTree.stringToTreeNode("[1,null,2,3,null,4,5]"), 5, 1));
    }
}