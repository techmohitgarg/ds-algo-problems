package com.mohit.leetcode.tree;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class TreePracticeSolution {
    TreeNode lastNode = null;
    TreeNode head = null;

    public static void main(String[] args) {
        TreePracticeSolution sol = new TreePracticeSolution();
        TreeNode root1 = MakeTree.stringToTreeNode("[5,3,6,2,4,null,7]");

    }


    //region Binary Tree Longest Consecutive Sequence
    int max = 0;

    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        longestConsecutiveSequencePath(root);
        return max;
    }

    public int longestConsecutiveSequencePath(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(1, longestConsecutiveSequencePath(node.left));
        int right = Math.max(1, longestConsecutiveSequencePath(node.right));
        if (node.left != null && node.left.val == node.val + 1) {
            left += 1;
        } else {
            left = 1;
        }
        if (node.right != null && node.right.val == node.val + 1) {
            right += 1;
        } else {
            right = 1;
        }
        max = Math.max(max, Math.max(left, right));
        return Math.max(left, right);
    }
    /*public int longestConsecutiveSequencePath(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(1,longestConsecutiveSequencePath(node.left));
        int right = Math.max(1,longestConsecutiveSequencePath(node.right));
        if (node.left != null) {
            left = node.val == node.left.val - 1 ? left + 1 : 1;
        }
        if (node.right != null) {
            right = node.val == node.right.val - 1 ? right + 1 : 1;
        }
        max = Math.max(max, Math.max(left, right));

        return Math.max(left, right);
    }*/
    //endregion

    //region Verify Preorder Sequence in Binary Search Tree
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length <= 1) return true;

        Stack<Integer> stack = new Stack<>();
        int min = Integer.MIN_VALUE;
        for (int i = 0; i < preorder.length; i++) {
            int node = preorder[i];

            if (node < min) {
                return false;
            }

            while (!stack.isEmpty() && stack.peek() < node) {
                min = stack.pop();
            }

            stack.push(node);
        }
        return true;
    }
    //endregion

    // region Binary Tree Upside Down
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;

        if (root.left == null && root.right == null)
            return root;

        TreeNode left = upsideDownBinaryTree(root.left);

        root.left.left = root.right;
        root.left.right = root;
        root.left = null;
        root.right = null;

        return left;

    }
    //endregion

    //region Count Univalue Subtrees
    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        int left = countUnivalSubtrees(root.left);
        int right = countUnivalSubtrees(root.right);
        if (isSameValue(root)) {
            count++;
        }
        return count + left + right;
    }

    private boolean isSameValue(TreeNode root) {
        if (root == null) return true;

        if ((root.left != null && root.val != root.left.val) ||
                (root.right != null && root.val != root.right.val)) {
            return false;
        }

        return isSameValue(root.left) && isSameValue(root.right);
    }
    //endregion

    //region Kth Smallest Element in a BST
    int kIdx = 0;

    public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;

        int left = kthSmallest(root.left, k);

        if (left != -1) {
            return left;
        }
        kIdx++;
        if (kIdx == k) return root.val;

        return kthSmallest(root.right, k);

    }
   /* public int kthSmallest(TreeNode root, int k) {
        if (root == null) return -1;
        Stack<TreeNode> nodes = new Stack<>();
        while (true) {
            if (root != null) {
                nodes.push(root);
                root = root.left;
            } else {
                if (nodes.isEmpty()) return -1;
                k--;
                root = nodes.pop();
                if (k == 0) return root.val;

                root = root.right;
            }
        }
    }*/
    //endregion

    //region Count Complete Tree Nodes
    /* public int countNodes(TreeNode root) {
     *//*if (root == null) return 0;
        return 1 + count(root);*//*
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }*/

    /*public int count(TreeNode root) {
        if (root == null) return 0;
        int count = 0;
        if (root.left != null && root.right != null) {
            count += 2;
        } else if (root.left != null && root.right == null) {
            count += 1;
        }
        return count + count(root.left) + count(root.right);
    }*/
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftH = 0;
        int rightH = 0;
        TreeNode pLeft = root;
        TreeNode pRight = root;

        while (pLeft != null) {
            pLeft = pLeft.left;
            leftH++;
        }
        while (pLeft != null) {
            pLeft = pLeft.right;
            rightH++;
        }

        if (leftH == rightH) return (int) Math.pow(2, leftH) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    //endregion

    //region Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        rightSideViewNodeList(root, list, 0);
        return list;
    }

    private void rightSideViewNodeList(TreeNode root, List<Integer> list, int level) {
        if (root == null) return;

        if (list.size() <= level) {
            list.add(root.val);
        }

        rightSideViewNodeList(root.right, list, level + 1);
        rightSideViewNodeList(root.left, list, level + 1);
    }
    //endregion

    //region Binary Search Tree Iterator
    class BSTIterator {

        Queue<Integer> queue = new LinkedList<>();

        public BSTIterator(TreeNode root) {
            inOrder(root);
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            if (queue.isEmpty()) return -1;
            return queue.poll().intValue();
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        private void inOrder(TreeNode node) {
            if (node == null) return;
            inOrder(node.left);
            queue.add(node.val);
            inOrder(node.right);
        }
    }
    //endregion

    //region Populating Next Right Pointers in Each Node II
    public Node connect(Node root) {
        if (root == null) return root;

        if (root.left != null) {
            // check if the right is not null
            if (root.right != null) {
                root.left.next = root.right;
            } else {
                // find the next right node at the same level
                root.left.next = findNext(root.next);
            }
        }
        if (root.right != null) {
            root.right.next = findNext(root.next);
        }

        connect(root.right);
        connect(root.left);

        return root;
    }

    private Node findNext(Node root) {
        if (root == null) return root;
        else if (root.left != null) return root.left;
        else if (root.right != null) return root.right;
        else return findNext(root.next);
    }
    /*public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                node.next = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {
                if (!queue.isEmpty())
                    queue.add(null);
            }
        }
        return root;
    }*/
    //endregion

    //region Populating Next Right Pointers in Each Node
    /*public Node connect(Node root) {
        if (root == null) return root;

        if (root.left != null) {
            root.left.next = root.right;
        }
        if (root.right != null) {
            if (root.next != null && root.next.left != null) {
                root.right.next = root.next.left;
            }
        }

        connect(root.left);
        connect(root.right);
        return root;
    }*/

    /*public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node != null) {
                node.next = queue.peek();

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            } else {

                if (!queue.isEmpty())
                    queue.add(null);
            }


        }
        return root;
    }*/
    //endregion

    //region Flatten Binary Tree to Linked List
    /*public void flatten(TreeNode root) {
        TreeNode t = root;
        while (t != null) {
            if (t.left == null) {
                t = t.right;
                continue;
            }
            TreeNode l = t.left;
            while (l.right != null) {
                l = l.right;
            }
            l.right = t.right;
            t.right = t.left;
            t.left = null;
        }


    }*/

    public void flatten(TreeNode root) {
        if (root == null) return;

        TreeNode temp = root.right;

        root.right = root.left;
        root.left = null;
        TreeNode cur = root;
        while (cur.right != null) {
            cur = cur.right;
        }
        cur.right = temp;
        flatten(root.right);

    }
    /*public void flatten (TreeNode root){
        if (root == null) return;
        Stack<TreeNode> nodes = new Stack<>();
        nodes.push(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.pop();
            if (node.right != null) nodes.push(node.right);
            if (node.left != null) nodes.push(node.left);
            node.left = null;
            node.right = nodes.isEmpty() ? null : nodes.peek();
        }
    }*/
    //endregion

    //region Path Sum II
    public List<List<Integer>> pathSum_(TreeNode root, int sum) {
        List<List<Integer>> list = new ArrayList<>();
        findPath(root, list, new ArrayList<>(), sum);
        return list;
    }

    private boolean findPath(TreeNode root, List<List<Integer>> lists, List<Integer> list, int sum) {
        if (root == null) return false;

        list.add(root.val);

        if (sum == root.val && root.left == null && root.right == null) {
            lists.add(new ArrayList<>(list));
        }

        if (root.left != null && findPath(root.left, lists, list, sum - root.val)) {
            return true;
        }
        if (root.right != null && findPath(root.right, lists, list, sum - root.val)) {
            return true;
        }
        list.remove(list.size() - 1);

        return false;
    }
    //endregion

    //region Construct Binary Tree from PostOrder and Inorder Traversal
    int postOrderPosition = 0;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positions.put(inorder[i], i);
        }
        postOrderPosition = postorder.length - 1;
        TreeNode result = buildTreeUsingPostOrder(positions, postorder, 0, inorder.length - 1);
        return result;
    }

    public TreeNode buildTreeUsingPostOrder(HashMap<Integer, Integer> inOrder, int[] postorder, int start, int end) {
        if (start <= end) {
            int mid = inOrder.get(postorder[postOrderPosition]);
            TreeNode node = new TreeNode(postorder[postOrderPosition]);
            postOrderPosition--;
            node.right = buildTreeUsingPostOrder(inOrder, postorder, mid + 1, end);
            node.left = buildTreeUsingPostOrder(inOrder, postorder, start, mid - 1);
            return node;
        }
        return null;
    }
    //endregion

    //region Construct Binary Tree from Preorder and Inorder Traversal
    int preOrderPositiom = 0;
    /*public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> positions = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            positions.put(inorder[i], i);
        }
        TreeNode result = buildTreeUsingPreOrder(preorder, positions, 0, inorder.length - 1);
        return result;
    }*/

    public TreeNode buildTreeUsingPreOrder(int[] preOrder, HashMap<Integer, Integer> inOrder, int start, int end) {
        if (preOrderPositiom < preOrder.length && start <= end) {
            int mid = inOrder.get(preOrder[preOrderPositiom]);
            TreeNode node = new TreeNode(preOrder[preOrderPositiom]);
            preOrderPositiom++;
            node.left = buildTreeUsingPreOrder(preOrder, inOrder, start, mid - 1);
            node.right = buildTreeUsingPreOrder(preOrder, inOrder, mid + 1, end);
            return node;
        }
        return null;
    }
    //endregion

    //region Binary Tree Zigzag Level Order Traversal
    public int[][] zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (A == null) return new int[][]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean b = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            ArrayList<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            b = !b;
            list.add(integers);

        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) {
            result[i] = new int[list.get(i).size()];
        }

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                result[i][j] = list.get(i).get(j);
            }
        }


        return result;
    }

    /*public int[][] zigzagLevelOrder(TreeNode A) {
        List<List<Integer>> list = new ArrayList<>();
        if (A == null) return new int[][]{};
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(A);
        boolean b = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            b = !b;
            list.add(integers);

        }
        int[][] result = new int[list.size()][];

        for (int i = 0; i < list.size(); i++) {
            int[] num = new int[list.get(i).size()];
            for (int j = 0; j < list.get(i).size(); j++) {
                num[j] = list.get(i).get(j);
            }
            result[i] = num;
        }

        return result;
    }*/


    /*public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean b = true;
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                if (b)
                    integers.add(node.val);
                else
                    integers.add(0, node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            b = !b;
            list.add(integers);

        }
        return list;
    }*/
    //endregion

    //region Binary Tree Level Order Traversal
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            List<Integer> integers = new ArrayList<>();
            while (len > 0) {

                TreeNode node = queue.poll();
                integers.add(node.val);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                len--;
            }
            list.add(integers);

        }
        return list;
    }
    //endregion

    //region Validate Binary Search Tree
    /*public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (left == false) return false;

        if (lastNode != null && lastNode.val >= root.val) {
            return false;
        }
        lastNode = root;
        return isValidBST(root.right);
    }*/

    //endregion

    //region Unique Binary Search Trees or Catalan number
    public int numTrees(int n) {
        if (n <= 1) return 1;
        int[] num = new int[n + 1];

        num[0] = 1;
        num[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                num[i] += num[j] * num[i - j - 1];
            }
        }

        return num[n];
    }
    //endregion

    //region Unique Binary Search Trees II
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return generate(1, n);
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> nodes = new ArrayList<>();
        if (start > end) {
            nodes.add(null);
            return nodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> left = generate(start, i - 1);
            List<TreeNode> right = generate(i + 1, end);
            for (TreeNode l : left) {
                for (TreeNode r : right) {
                    TreeNode node = new TreeNode(i);
                    node.left = l;
                    node.right = r;
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }
    //endregion

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







































}