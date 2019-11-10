package com.mohit.leetcode.tree.medium;

import com.mohit.TreeBookPractice;
import com.mohit.leetcode.tree.MakeTree;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.Assert.*;

public class BinaryTreeRightSideViewTest {
    BinaryTreeRightSideView rightSideView = null;

    @Before
    public void setUp() throws Exception {
        rightSideView = new BinaryTreeRightSideView();
    }

    @Test
    public void rightSideView() {
        assertArrayEquals(Arrays.asList(new int[]{1, 3, 4}).toArray(),
                rightSideView.rightSideView(MakeTree.stringToTreeNode("[1,2,3,null,5,null,4]")).toArray());

        assertArrayEquals(Arrays.asList(new int[]{1, 2, 5, 7}).toArray(),
                rightSideView.rightSideView(MakeTree.stringToTreeNode("[1,2,null,4,5,null,null,6,7]")).toArray());

        assertArrayEquals(Arrays.asList(new int[]{1, 2, 5, 6, 7}).toArray(),
                rightSideView.rightSideView(MakeTree.stringToTreeNode("[1,2,null,4,5,null,null,6,null,7]")).toArray());
    }

}