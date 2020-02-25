package com.mohit;

import com.mohit.leetcode.linklist.ListNode;

import java.util.*;

public class Solution {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        public Node setRandom(Node random) {
            this.random = random;
            return this;
        }

    }

    //[[7,null],[13,0],[11,4],[10,2],[1,0]]
    // [[1,1],[2,1]]
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countFriendsPairings(5));
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node, Node> map = new HashMap<>();

        Node oldNode = head;
        Node deepNode = new Node(oldNode.val);
        Node itr = deepNode;

        map.put(head, deepNode);


        while (oldNode.next != null) {
            itr.next = new Node(oldNode.next.val);
            map.put(oldNode.next, itr.next);
            oldNode = oldNode.next;
            itr = itr.next;
        }


        oldNode = head;
        itr = deepNode;
        while (oldNode!=null){
            itr.random=map.get(oldNode.random);
            oldNode = oldNode.next;
            itr = itr.next;
        }


        return deepNode;
    }

    private Node getNewNode(Node node, int index, HashMap<Integer, Node> map) {
        if (node == null) return null;
        if (map.containsValue(index)) return map.get(index);
        Node n = new Node(node.val);
        n.next = node.next;
        n.random = getNewNode(node.random, (node.random == null ? -1 : node.val), map);

        // Adding the new update node in the map
        map.put(index, n);

        return n;
    }

    private int countFriendsPairings(int n) {
        int dp[] = new int[n + 1];

        // Filling dp[] in bottom-up manner using
        // recursive formula explained above.
        for (int i = 0; i <= n; i++) {
            if (i <= 2)
                dp[i] = i;
            else
                dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }

        return dp[n];
    }


}

