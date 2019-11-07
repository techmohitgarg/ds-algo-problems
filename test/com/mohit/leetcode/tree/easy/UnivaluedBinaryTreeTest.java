package com.mohit.leetcode.tree.easy;

import com.mohit.leetcode.tree.MakeTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class UnivaluedBinaryTreeTest {
    UnivaluedBinaryTree binaryTree = null;

    @Before
    public void setUp() throws Exception {
        binaryTree = new UnivaluedBinaryTree();
    }

    @Test
    public void isUnivalTree() {
        Assert.assertEquals(true, binaryTree.isUnivalTree(MakeTree.stringToTreeNode("[1,1,1,1,1,null,1]")));
        Assert.assertEquals(false, binaryTree.isUnivalTree(MakeTree.stringToTreeNode("[2,2,2,5,2]")));
    }
}