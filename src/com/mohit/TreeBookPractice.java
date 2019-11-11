package com.mohit;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.leetcode.tree.Node;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class TreeBookPractice {

    public static void main(String[] args) {
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root = makeBST(nums, 0, nums.length - 1);
        return root;
    }


    private TreeNode makeBST(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeBST(nums, left, mid - 1);
        node.right = makeBST(nums, mid + 1, right);
        return node;

    }

}