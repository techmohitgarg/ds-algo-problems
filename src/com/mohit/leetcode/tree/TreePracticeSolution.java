package com.mohit.leetcode.tree;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class TreePracticeSolution {

    public static void main(String[] args) {
        TreePracticeSolution sol = new TreePracticeSolution();
        TreeNode root1 = MakeTree.stringToTreeNode("[1,2,3]");
        System.out.println(sol.sumNumbers(root1));

    }

    //region Sum Root to Leaf Numbers
    int sum = 0;

    public int sumNumbers(TreeNode A) {
        if (A == null) return 0;
        sumNumbersRootToLeaf(A, 0);
        return sum % 1003;
    }

    public void sumNumbersRootToLeaf(TreeNode root, int sum) {
        if (root == null) return;

        sum = (sum * 10) + root.val;
        sumNumbersRootToLeaf(root.left, sum);
        sumNumbersRootToLeaf(root.right, sum);
        if (root.left == null && root.right == null) {
            this.sum = (this.sum + sum) % 1003;
        }
    }
    //endregion

    //region Sum of Root To Leaf Binary Numbers
    public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        sumRootToLeaf(root, 0);
        return sum;
    }

    public void sumRootToLeaf(TreeNode root, int sum) {
        if (root == null) return;

        sum = (sum * 2) + root.val;
        sumRootToLeaf(root.left, sum);
        sumRootToLeaf(root.right, sum);
        if (root.left == null && root.right == null) {
            this.sum += sum;
        }
    }
    /*public int sumRootToLeaf(TreeNode root) {
        if (root == null) return 0;
        sumRootToLeaf(root, new ArrayList<>());
        return sum;
    }*/

    public void sumRootToLeaf(TreeNode root, List<Integer> list) {
        if (root == null) return;

        list.add(root.val);
        sumRootToLeaf(root.left, list);
        sumRootToLeaf(root.right, list);
        if (root.left == null && root.right == null) {
            int decimal = 0;
            int i = 0;
            for (int j = list.size() - 1; j >= 0; j--) {
                decimal += Math.pow(2, i) * list.get(j);
                i++;
            }
            sum += decimal;
        }
        list.remove(list.size() - 1);
    }
    //endregion

    //region Cousins in Binary Tree
    int xD = 0;
    int yD = 0;
    TreeNode xP = null;
    TreeNode yP = null;

    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;

        return isCousins(root, x, y, null, 0);
    }

    private boolean isCousins(TreeNode root, int x, int y, TreeNode parent, int depth) {
        if (xD > 0 && xD == yD && xP != yP) {
            return true;
        }
        if (root == null) return false;

        if (root.val == x) {
            xD = depth;
            xP = parent;
        } else if (root.val == y) {
            yD = depth;
            yP = parent;
        }
        return isCousins(root.left, x, y, root, depth + 1) || isCousins(root.right, x, y, root, depth + 1);
    }


    /*public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            boolean XMatch = false;
            boolean YMatch = false;
            int len = nodes.size();
            while (len > 0) {
                TreeNode node = nodes.poll();

                if (node.left != null && node.left.val == x) {
                    XMatch = true;
                } else if (node.right != null && node.right.val == x) {
                    XMatch = true;
                } else if (node.left != null && node.left.val == y) {
                    YMatch = true;
                } else if (node.right != null && node.right.val == y) {
                    YMatch = true;
                }

                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);


                if (XMatch && YMatch) return true;

                len--;
            }

        }

        return false;
    }*/
    //endregion

    //region Univalued Binary Tree
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        if ((root.left != null && root.val != root.left.val) ||
                (root.right != null && root.val != root.right.val)) {
            return false;
        }

        return isUnivalTree(root.left) && isUnivalTree(root.right);
    }
    //endregion

    //region Inorder Traversal
    public int[] inorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        while (true) {
            if (A != null) {
                queue.add(A);
                A = A.left;
            } else {
                if (queue.isEmpty()) break;

                A = queue.pop();

                list.add(A.val);

                A = A.right;
            }
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    //endregion

    //region Range Sum of BST
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        int count = 0;
        if (root.val >= L && root.val <= R) {
            count += root.val;
        }
        if (L < root.val) {
            count += rangeSumBST(root.left, L, R);
        }
        if (R > root.val) {
            count += rangeSumBST(root.right, L, R);
        }
        return count;
    }
    //endregion

    //region Increasing Order Search Tree
    TreeNode cur;

    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }

//    public TreeNode increasingBST(TreeNode root) {
//        if (root == null) return null;
//
//        Queue<TreeNode> nodes = new LinkedList<>();
//        //Get the Nodes in Inorder Manner
//        inOrder(root, nodes);
//
//        // Assign the root=null;
//        root = new TreeNode(0);
//        TreeNode curr = root;
//        while (!nodes.isEmpty()) {
//            curr.right = new TreeNode(nodes.poll().val);
//            curr = curr.right;
//        }
//
//        /*// Assign the root=null;
//        root = null;
//        while (!nodes.isEmpty())
//            root = makeRightBinarySearchTree(root, nodes.poll().val);*/
//
//
//        return root.right;
//    }

    private TreeNode makeRightBinarySearchTree(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        root.left = null;
        root.right = makeRightBinarySearchTree(root.right, val);

        return root;
    }

    private void inOrder(TreeNode root, Queue<TreeNode> list) {
        if (root == null) return;

        inOrder(root.left, list);
        list.add(root);
        inOrder(root.right, list);
    }
    //endregion

    //region Leaf-Similar Trees
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        Queue<Integer> stack = new LinkedList<>();

        addLeafsNode(root1, stack, true);

        if (!addLeafsNode(root2, stack, false)) {
            return false;
        }
        return stack.isEmpty() ? true : false;
    }

    private boolean addLeafsNode(TreeNode root, Queue<Integer> stack, boolean isAdd) {
        if (root == null) return true;

        if (root.left == null && root.right == null) {
            if (isAdd) {
                stack.add(root.val);
                return true;
            } else {
                if (stack.isEmpty() || stack.peek() != root.val) {
                    return false;
                } else {
                    stack.poll();
                    return true;
                }
            }

        }
        return addLeafsNode(root.left, stack, isAdd) && addLeafsNode(root.right, stack, isAdd);
    }
    //endregion

    //region Minimum Distance Between BST Nodes
    public int minDiffInBST(TreeNode root) {
        if (root == null) return 0;
        int result = minDiffBetweenNodes(root);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minDiffBetweenNodes(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = minDiffBetweenNodes(root.left);
        int diff = Integer.MAX_VALUE;
        if (prev != null) {
            diff = root.val - prev;
        }
        //Update the Previous
        prev = root.val;

        int right = minABSDiffBetweenNodes(root.right);

        return Math.min(diff, Math.min(left, right));
    }

    //endregion

    //region Search in a Binary Search Tree
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;

        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }
    //endregion

    //region Longest Univalue Path
    int ans;

    public int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        findTheLongestPath(root);
        return ans;
    }

    public int findTheLongestPath(TreeNode root) {
        if (root == null) return 0;

        int left = findTheLongestPath(root.left);
        int right = findTheLongestPath(root.right);
        int arrowLeft = 0, arrowRight = 0;

        if (root.left != null && root.val == root.left.val) {
            arrowLeft += 1 + left;
        }
        if (root.right != null && root.val == root.right.val) {
            arrowRight += 1 + right;
        }

        ans = Math.max(ans, arrowLeft + arrowRight);

        return Math.max(arrowLeft, arrowRight);
    }
    //endregion

    // region Second Minimum Node In a Binary Tree
    Integer first = null, second = null;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) return -1;

        findMinNumber(root);
        return (second == null || first == second) ? -1 : second;
    }


    private void findMinNumber(TreeNode root) {
        if (root == null) return;

        if (first == null || first > root.val) {
            second = first;
            first = root.val;
        }
        if (root.val > first) {
            if (second == null || (root.val < second)) {
                second = root.val;
            }
        }
        findMinNumber(root.left);
        findMinNumber(root.right);
    }

    //endregion

    //region Trim a Binary Search Tree
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;

        if (root.val > R) {
            return trimBST(root.left, L, R);
        }
        if (root.val < L) {
            return trimBST(root.right, L, R);
        }

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);

        return root;
    }

    /*public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        List<Integer> list = new ArrayList<>();

        itrTree(root, L, R, list);
        TreeNode node = null;
        for (int i = 0; i < list.size(); i++) {
            node = BST(node, list.get(i));
        }
        return node;
    }

    private void itrTree(TreeNode root, int L, int R, List<Integer> list) {
        if (root == null) return;
        if (root.val >= L && root.val <= R) {
            list.add(root.val);
        }
        itrTree(root.left, L, R, list);
        itrTree(root.right, L, R, list);
    }

    public TreeNode BST(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);

        if (root.val >= val) {
            root.left = BST(root.left, val);
        } else {
            root.right = BST(root.right, val);
        }

        return root;
    }*/
    //endregion

    //region Two Sum IV - Input is a BST
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;

        return target(root, k, new HashSet<>());
    }

    private boolean target(TreeNode root, int k, HashSet<Integer> set) {
        if (root == null) return false;

        if (set.contains(k - root.val)) return true;

        set.add(root.val);

        return target(root.left, k, set) || target(root.right, k, set);
    }
    //endregion

    //region Average of Levels in Binary Tree
    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> avgList = new ArrayList<>();

        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            double sum = 0;
            int len = nodes.size();
            for (int i = 0; i < len; i++) {
                TreeNode node = nodes.poll();
                sum += node.val;

                if (node.left != null) nodes.add(node.left);
                if (node.right != null) nodes.add(node.right);

            }
            avgList.add(sum / len);

        }
        return avgList;
    }
    //endregion

    //region Merge Two Binary Trees
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null && t2 == null) return null;

        if (t1 == null) return t2;

        if (t2 == null) return t1;

        TreeNode node = new TreeNode(t1.val + t2.val);
        node.left = mergeTrees(t1.left, t2.left);
        node.right = mergeTrees(t1.right, t2.right);

        return node;
    }
    //endregion

    //region Construct String from Binary Tree
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder builder = new StringBuilder();
        constructStringUsingTree(t, builder);
        return builder.toString();
    }


    private void constructStringUsingTree(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val);
        if (root.left != null) {
            sb.append("(");
            constructStringUsingTree(root.left, sb);
            sb.append(")");
        }
        if (root.right != null) {
            if (root.left == null) {
                sb.append("()");
            }
            sb.append("(");
            constructStringUsingTree(root.right, sb);
            sb.append(")");
        }
    }
    //endregion

    //region N-ary Tree Postorder Traversal
    public List<Integer> postorder(Node root) {
        List<Integer> postOrder = new ArrayList<>();
        postOrderList(root, postOrder);
        return postOrder;
    }

    private void postOrderList(Node root, List<Integer> postOrder) {
        if (root == null) return;
        // Traverse All the children one by one
        for (int i = 0; i < root.children.size(); i++) {
            postOrderList(root.children.get(i), postOrder);
        }
        // Add the Value here
        postOrder.add(root.val);
    }
    //endregion

    //region N-ary Tree Preorder Traversal
    public List<Integer> preorder(Node root) {
        List<Integer> preOrder = new ArrayList<>();
        preOrderList(root, preOrder);
        return preOrder;
    }

    private void preOrderList(Node root, List<Integer> preOrder) {
        if (root == null) return;
        // Add the Value here
        preOrder.add(root.val);
        // Traverse All the children one by one
        for (int i = 0; i < root.children.size(); i++) {
            preOrderList(root.children.get(i), preOrder);
        }
    }
    //endregion

    //region Subtree of Another Tree
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) return false;

        if (isSameTree(s, t)) {
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    //endregion

    // region Binary Tree Tilt
    int tilt = 0;

    public int findTilt(TreeNode root) {
        if (root == null) return 0;
        tilt(root);
        return tilt;
    }

    public int tilt(TreeNode root) {
        if (root == null) return 0;
        int left = tilt(root.left);
        int right = tilt(root.right);
        tilt += Math.abs(left - right);
        return left + right + root.val;
    }
    //endregion

    //region Maximum Depth of N-ary Tree
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public int maxDepth(Node root) {
        if (root == null) return 0;

        int count = 1;
        for (int i = 0; i < root.children.size(); i++) {
            count += Math.max(count, maxDepth(root.children.get(i)) + 1);
        }
        return count;
    }
    //endregion

    //region Diameter of binary tree
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int len1 = maxDepth(root.left) + maxDepth(root.right);
        int len2 = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(len1, len2);
    }
    //endregion

    //region Binary Search Tree to Greater Sum Tree
    TreeNode lastNode = null;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) return null;
        convertBstToGst(root);
        return root;
    }

    private void convertBstToGst(TreeNode root) {
        if (root == null) return;

        convertBstToGst(root.right);

        if (lastNode != null) {
            root.val += lastNode.val;
        }

        lastNode = root;

        convertBstToGst(root.left);

    }
    //endregion

    //region Minimum Absolute Difference in BST
    Integer prev = null;

    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        int result = minABSDiffBetweenNodes(root);
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public int minABSDiffBetweenNodes(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;

        int left = minABSDiffBetweenNodes(root.left);
        int diff = Integer.MAX_VALUE;
        if (prev != null) {
            diff = Math.abs(prev - root.val);
        }
        //Update the Previous
        prev = root.val;

        int right = minDiffBetweenNodes(root.right);

        return Math.min(diff, Math.min(left, right));
    }
    //endregion

    //region Find Mode in Binary Search Tree
    public int[] findMode_(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        countAllTheNumber(root, list);
        int[] data = new int[list.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = list.get(i);
        }
        return data;
    }

    private int countAllTheNumber(TreeNode root, ArrayList<Integer> integers) {
        if (root == null) return 0;
        Stack<TreeNode> nodes = new Stack<>();
        int maxCount = 0;
        TreeNode prev = null;
        int count = 0;
        while (true) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                if (nodes.isEmpty()) break;
                root = nodes.pop();
                if (prev != null && prev.val == root.val) {
                    count += 1;
                } else {
                    count = 1;
                }
                if (count > maxCount) {
                    integers.clear();
                    maxCount = count;
                    integers.add(root.val);
                } else if (count == maxCount) {
                    integers.add(root.val);
                }
                prev = root;
                root = root.right;

            }

        }
        return maxCount;
    }

    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxCount = countAllTheNumber(root, map);
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<Integer, Integer> set : map.entrySet()) {
            if (set.getValue() == maxCount) {
                list.add(set.getKey());
            }
        }
        int[] data = new int[list.size()];
        for (int i = 0; i < data.length; i++) {
            data[i] = list.get(i);
        }
        return data;
    }

    private int countAllTheNumber(TreeNode root, HashMap<Integer, Integer> map) {
        if (root == null) return 0;
        int left = countAllTheNumber(root.left, map);
        int right = countAllTheNumber(root.right, map);
        map.put(root.val, map.getOrDefault(root.val, 0) + 1);
        int maxCount = Math.max(Math.max(left, right), map.get(root.val));
        return maxCount;
    }
    //endregion

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

    //region Sum of Left Leaves

    /**
     * @param root tree
     * @return sum of all the left nodes
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;

        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }

        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    private int sumofLeft(TreeNode root, boolean isLeft) {
        if (root == null) return 0;
        int sum = 0;
        if (isLeft && root.left == null && root.right == null) {
            sum += root.val;
        }
        return sum + sumofLeft(root.left, true) + sumofLeft(root.right, false);
    }
    //endregion

    //region Binary Tree Paths
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        findPathRootToleaf(root, paths, new ArrayList<>());
        return paths;
    }

    private void findPathRootToleaf(TreeNode root, List<String> pathList, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            for (i = 0; i < list.size() - 1; i++) {
                sb.append(list.get(i));
                sb.append("->");
            }
            sb.append(list.get(i));
            pathList.add(sb.toString());
        }

        findPathRootToleaf(root.left, pathList, list);
        findPathRootToleaf(root.right, pathList, list);
        list.remove(list.size() - 1);
    }

    //endregion

    //region Lowest Common Ancestor in a Binary Tree

    /**
     * @param A tree
     * @param B node value
     * @param C node value
     * @return Ancestor of the tree
     */

    public int lca(TreeNode A, int B, int C) {
        TreeNode result = lcaNode(A, B, C);
        return result == null ? -1 : result.val;
    }

    public TreeNode lcaNode(TreeNode A, int B, int C) {
        if (A == null) return null;


        if (A.val == B || A.val == C) {
            return A;
        }

        TreeNode left = lcaNode(A.left, B, C);
        TreeNode right = lcaNode(A.right, B, C);

        if (left != null && right != null) {
            return A;
        }

        return left != null ? left : right;
    }

    public int lcaUsingList(TreeNode A, int B, int C) {
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();

        if (!findPath(one, A, B) || !findPath(two, A, C)) {
            return -1;
        }
        int i;
        for (i = 0; i < one.size() && i < two.size(); i++) {


            if (!one.get(i).equals(two.get(i)))
                break;
        }

        return one.get(i - 1);
    }

    public boolean findPath(List<Integer> list, TreeNode A, int val) {
        if (A == null) return false;

        list.add(A.val);

        if (A.val == val) return true;

        if (A.left != null && findPath(list, A.left, val)) {
            return true;
        }
        if (A.right != null && findPath(list, A.right, val)) {
            return true;
        }

        list.remove(list.size() - 1);

        return false;
    }
    //endregion

    //region Lowest Common Ancestor of a Binary Search Tree

    /**
     * @param root tree
     * @param p    node one
     * @param q    node two
     * @return Ancestor of the tree
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        while (root != null) {
            if (root != null) {
                if (root.val > p.val && root.val > q.val) {
                    root = root.left;
                } else if (root.val < p.val && root.val < q.val) {
                    root = root.right;
                } else {
                    break;
                }
            }
        }
        return root;
    }

    public TreeNode lowestCommonAncestorUsingRecursion(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
    //endregion

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