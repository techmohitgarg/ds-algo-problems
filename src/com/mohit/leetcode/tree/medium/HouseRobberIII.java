package com.mohit.leetcode.tree.medium;

import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HouseRobberIII {

    public static void main(String[] args) {
        //[4,1,null,2,null,3]
        System.out.println(new HouseRobberIII().rob(MakeTree.stringToTreeNode("[2,1,3,null,4]")));
    }

    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }

        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);
        int sumOfRow = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {
                sumOfRow += node.val;
                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);

            } else {
                list.add(sumOfRow);
                sumOfRow = 0;
                if (!nodes.isEmpty()) {
                    nodes.add(null);
                }

            }

        }
        // Find the Max Number of robbery amount
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            int sum = list.get(i).intValue();
            for (int j = i + 1; j < list.size(); j++) {
                int k = j + 1;
                int tempSum = 0;
                while (k < list.size()) {
                    int val = list.get(k).intValue();
                    tempSum += val;
                    max = Math.max(max, sum + tempSum);
                    k += 2;
                }
                max = Math.max(max, sum + tempSum);
            }
            max = Math.max(max, sum);
        }
        return (max == Integer.MIN_VALUE) ? 0 : max;
    }

    /*
    //Working Solution
    public int rob(TreeNode root) {
        if(root == null) return 0;
        else if(root.left == null && root.right == null) return root.val;
        else{
            int hasroot = root.val;
            int Nroot = 0;
            if(root.left != null){
                Nroot = Nroot+rob(root.left);
                if(root.left.left != null)
                    hasroot =hasroot+ rob(root.left.left);
                if(root.left.right != null)
                    hasroot =hasroot+ rob(root.left.right);
            }
            if(root.right != null){
                Nroot = Nroot+rob(root.right);
                if(root.right.left != null)
                    hasroot =hasroot+ rob(root.right.left);
                if(root.right.right != null)
                    hasroot =hasroot+ rob(root.right.right);
            }
            return Math.max(hasroot, Nroot);
        }

    }*/

}
