package com.mohit.leetcode.tree;


import com.mohit.leetcode.linklist.ListNode;
import com.mohit.tree.book_practice.binary_tree.TreeNode;

import java.util.*;

public class TreePracticeSolution {

    public static void main(String[] args) {
        TreePracticeSolution sol = new TreePracticeSolution();
        //TreeNode root1 = MakeTree.stringToTreeNode("[1,#,3,2,3,#,#,#,3]".replace("#", "null"));
        TreeNode root1 = MakeTree.stringToTreeNode("[1,2,3,4,5]");
        List<List<Integer>> result = sol.findLeaves(root1);
        System.out.println(result);
    }


    //region Find Leaves of Binary Tree
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, root);
        return result;
    }
    private int helper(List<List<Integer>> list, TreeNode root) {
        if (root == null)
            return -1;

        int left = helper(list, root.left);
        int right = helper(list, root.right);
        int curr = Math.max(left, right) + 1;

        // the first time this code is reached is when curr==0,
        //since the tree is bottom-up processed.
        if (list.size() <= curr) {
            list.add(new ArrayList<Integer>());
        }

        list.get(curr).add(root.val);

        return curr;
    }


    /*public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> listOfLeaves = new ArrayList<>();
        if (root == null) return listOfLeaves;

        while (root != null) {
            List<Integer> list = new ArrayList<>();
            root = findLeavesList(list, root);
            listOfLeaves.add(list);
        }
        return listOfLeaves;
    }


    private TreeNode findLeavesList(List<Integer> list, TreeNode root) {
        if (root == null) return null;

        if (root.left == null && root.right == null) {
            list.add(root.val);
            return null;
        }
        TreeNode left = findLeavesList(list, root.left);
        TreeNode right = findLeavesList(list, root.right);
        root.left = left;
        root.right = right;
        return root;
    }*/
    //endregion

    //region House Robber III
    public int rob(TreeNode root) {
        if (root == null) return 0;

        int[] result = dfs(root);
        return Math.max(result[0], result[1]);

    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int[] result = new int[2];

        result[0] = root.val + left[1] + right[1];
        result[1] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return result;
    }
    //endregion

    //region Inorder Successor in BST
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // if node P right side is not null
        if (root == null || p == null)
            return null;

        if (p.right != null)
            return minNodeOfTheTree(p.right);


        TreeNode current = root;
        TreeNode succ = null;
        while (current != null) {
            if (current.val < p.val) {
                current = current.right;
            } else if (current.val > p.val) {
                succ = current;
                current = current.left;
            } else {
                break;
            }

        }
        return succ;
    }

    public TreeNode minNodeOfTheTree(TreeNode root) {
        if (root == null) return root;

        TreeNode current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }
    //endregion

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        if (left == false) return false;

        if (lastNode != null && lastNode.val >= root.val) {
            return false;
        }
        lastNode = root;
        return isValidBST(root.right);
    }
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

    //region Preorder Traversal
    public int[] preorderTraversal(TreeNode A) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> queue = new Stack<>();
        queue.push(A);
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            list.add(node.val);

            if (node.right != null)
                queue.push(node.right);
            if (node.left != null)
                queue.push(node.left);
        }

        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
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