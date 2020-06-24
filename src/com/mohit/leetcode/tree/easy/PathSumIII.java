package com.mohit.leetcode.tree.easy;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class PathSumIII {
    public static void main(String[] s) {
        PathSumIII sumIII = new PathSumIII();
        TreeNode node = MakeTree.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int sum = 22;
        System.out.println(sumIII.pathSum(node, sum));
    }


    public int pathSum1(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = path(root, sum);
        count += pathSum1(root.left, sum);
        count += pathSum1(root.right, sum);
        return count;
    }

    public int path(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.val == sum) {
            count++;
        }
        count += path(root.left, sum - root.val);
        count += path(root.right, sum - root.val);
        return count;
    }

    //region Path Sum III
    private int printPath(List<Integer> list, TreeNode node, int sum) {
        if (node == null) return 0;
        list.add(node.val);
        int left = printPath(list, node.left, sum);
        int right = printPath(list, node.right, sum);

        int count = 0;
        int temp = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            temp += list.get(i);
            if (temp == sum) {
                count++;
            }
        }

        list.remove(list.size() - 1);
        return count + left + right;
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;

        int count = pathSumExist(root, sum);
        count += pathSum(root.left, sum);
        count += pathSum(root.right, sum);
        return count;
    }

    public int pathSumExist(TreeNode root, int sum) {
        if (root == null) return 0;

        int count = 0;
        if (root.val == sum) {
            count++;
        }
        count += pathSumExist(root.left, sum - root.val);
        count += pathSumExist(root.right, sum - root.val);
        return count;
    }
    //endregion
}

