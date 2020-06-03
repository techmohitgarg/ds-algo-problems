package com.mohit.leetcode.tree.easy;


import com.mohit.leetcode.tree.MakeTree;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;


public class PathSumIII {
    public static void main(String[] s) {
        PathSumIII sumIII = new PathSumIII();
        TreeNode node = MakeTree.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        int sum = 22;
        System.out.println(sumIII.pathSum(node, sum));
        System.out.println(sumIII.pathSum2(node, sum));
    }


    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        HashMap<Integer, Integer> perSum = new HashMap<>();
        int count = sumCount(root, 0, sum, perSum);
        return count;
    }


    public int sumCount(TreeNode root, int currentSum, int target, HashMap<Integer, Integer> perSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        currentSum += root.val;
        if (perSum.containsKey(currentSum - target)) {
            count += perSum.get(currentSum - target);
        }

        if (!perSum.containsKey(currentSum)) {
            perSum.put(currentSum, 1);
        } else {
            perSum.put(currentSum, perSum.get(currentSum) + 1);
        }
        count += sumCount(root.left, currentSum, target, perSum);
        count += sumCount(root.right, currentSum, target, perSum);
        perSum.put(currentSum, perSum.get(currentSum) - 1);
        return count;
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


    public int pathSum2(TreeNode root, int sum) {
        if (root == null) return 0;
        int count = sum(root, sum, new ArrayList<>());
        return count;
    }

    public int sum(TreeNode root, int sum, ArrayList<Integer> data) {
        if (root == null) return 0;
        data.add(root.val);
        int left = sum(root.left, sum, data);
        int right = sum(root.right, sum, data);

        int count = 0;
        int val = 0;
        for (int i = data.size() - 1; i >= 0; i--) {
            val += data.get(i);
            if (val == sum) count++;
        }
        data.remove(data.size() - 1);
        return count + left + right;
    }

    //Need to more works on this

   /* public int pathSum_(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        k_paths(root, sum, new HashMap<>(), 0, res);
        return res;
    }

    void k_paths(TreeNode root, int k, HashMap<Integer, Integer> p,
                 int sum, int res) {
        // If root is not null
        if (root != null) {
            // If root value and previous sum equal
            // to k then increase the count
            if (sum + root.val == k)
                res++;

            // Add those values also which differes
            // by the current sum and root data by k
            res += p.containsKey(sum + root.val - k) ? p.get(sum + root.val - k) : 0;

            // Insert the sum + root value in the map
            //p[sum + root -> data]++;
            p.put(sum + root.val, p.getOrDefault(sum + root.val, 0) + 1);

            // Move to left and right trees
            k_paths(root.left, k, p, sum + root.val, res);
            k_paths(root.right, k, p, sum + root.val, res);

            // remove the sum + root->data value from the
            // map if they are n not required further or
            // they do no sum up to k in any way
            //p[sum + root -> data]--;
            p.put(sum + root.val, p.getOrDefault(sum + root.val, 0) - 1);
        }
    }*/
}

