package com.mohit.tree.book_practice.binary_tree;

import java.util.ArrayList;
import java.util.List;

public class GenerateAllDifferentBSTsWithNNodes {

    public static void main(String[] args) {
        GenerateAllDifferentBSTsWithNNodes bsTsWithNNodes = new GenerateAllDifferentBSTsWithNNodes();
        int n = 3;
        List<TreeNode> nodeList = bsTsWithNNodes.getList(3);
        System.out.println(nodeList);
    }


    public List<TreeNode> getList(int n) {
        return getAllBinaryTree(1, n);
    }

    public List<TreeNode> getAllBinaryTree(int start, int end) {
        List<TreeNode> nodeList = new ArrayList<>();
        if (start > end) {
            nodeList.add(null);
            return nodeList;
        }
        for (int i = start; i <= end; i++) {
            for (TreeNode left : getAllBinaryTree(start, i - 1)) {
                for (TreeNode right : getAllBinaryTree(i + 1, end)) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    nodeList.add(node);
                }
            }
        }
        return nodeList;
    }


}
