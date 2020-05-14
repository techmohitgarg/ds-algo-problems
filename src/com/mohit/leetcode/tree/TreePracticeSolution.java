package com.mohit.leetcode.tree;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreePracticeSolution {


    public static void main(String[] args) {
        TreePracticeSolution sol = new TreePracticeSolution();
        TreeNode root = MakeTree.stringToTreeNode("[4,2,7,1,3,6,9]");
        TreeNode result = sol.invertTree(root);
        System.out.println(result);
    }

    //region invertTree
    /**
     * @param root tree
     * @return invert tree
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        invertTree(root.left);
        invertTree(root.right);

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
    //endregion

    //region hasPathSum

    /**
     * @param root tree
     * @param sum  sum need to find in the tree
     * @return either sum exist or not from root to leaf node
     */
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.val == sum && root.left == null && root.right == null) {
            return true;
        }
        return hasPathSum(root.left, sum - root.val) ||
                hasPathSum(root.right, sum - root.val);
    }
    //endregion

    //region minDepth

    /**
     * @param root tree
     * @return return min Depth of the tree
     */
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left == null) {
            return 1 + minDepth(root.right);
        }
        if (root.right == null) {
            return 1 + minDepth(root.left);
        }

        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
    //endregion

    //region isBalanced using Recursion
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return maxDepthForBalancedTree(root) == -1 ? false : true;
    }

    public int maxDepthForBalancedTree(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepthForBalancedTree(root.left);
        int right = maxDepthForBalancedTree(root.right);
        if (left == -1 || right == -1) return -1;
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        return 1 + Math.max(left, right);
    }
    //endregion

    //region sortedArrayToBST using Recursion

    /**
     * @param nums Sorted Array
     * @return return binary search tree
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode makeBinaryTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (right + left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeBinaryTree(nums, left, mid - 1);
        node.right = makeBinaryTree(nums, mid + 1, right);
        return node;
    }

    public TreeNode sortedArrayToBST(final List<Integer> A) {
        return makeBinaryTree(A, 0, A.size() - 1);
    }

    private TreeNode makeBinaryTree(List<Integer> nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode l = makeBinaryTree(nums, left, mid - 1);
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = l;
        node.right = makeBinaryTree(nums, mid + 1, right);
        return node;
    }
    //endregion

    //region levelOrderBottom using iteration

    /**
     * @param root tree
     * @return list of all level nodes
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> list = new ArrayList<>();
            while (len-- > 0) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            result.add(0, list);
        }
        return result;
    }
    //endregion

    //region maxDepth using recursion and iteration

    /**
     * @param root tree
     * @return max Depth of the tree
     */
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public int maxDepthUsingIteration(TreeNode root) {
        if (root == null) return 0;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        nodes.add(null);
        int max = 0;
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node != null) {

                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);


            } else {
                max++;
                if (!nodes.isEmpty()) {
                    nodes.add(null);
                }
            }

        }

        return max;
    }

    //endregion

    //region isSymmetric using recursion and iteration

    /**
     * @param root tree
     * @return true or false
     */

    public boolean isSymmetric(TreeNode root) {
        return isSameSymmetricForAllChild(root, root);
    }

    public boolean isSameSymmetricForAllChild(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        }
        return isSameSymmetricForAllChild(p.left, q.right) && isSameSymmetricForAllChild(p.right, q.left);
    }

    public boolean isSymmetricUsingIteration(TreeNode root) {
        if (root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            // Base Case's
            //Check the node whether match or not
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;

            // Add the Child node in the Queue
            queue.add(left.left);
            queue.add(right.right);
            queue.add(left.right);
            queue.add(right.left);
        }
        return true;
    }
    //endregion and Iteration and Iteration

    //region isSameTree using recursion and iteration

    /**
     * @param p tree
     * @param q tree
     * @return true or false
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeUsingIteration(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(p);
        nodes.add(q);
        while (!nodes.isEmpty()) {
            TreeNode pNode = nodes.poll();
            TreeNode qNode = nodes.poll();
            if (pNode == null && qNode == null) continue;
            if (pNode == null || qNode == null) return false;
            if (pNode.val != qNode.val) return false;

            nodes.add(pNode.left);
            nodes.add(qNode.left);

            nodes.add(pNode.right);
            nodes.add(qNode.right);
        }

        return true;
    }

    //endregion

}