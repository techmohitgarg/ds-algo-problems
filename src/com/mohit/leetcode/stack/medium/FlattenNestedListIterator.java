package com.mohit.leetcode.stack.medium;

import java.util.*;

public class FlattenNestedListIterator {

    public static void main(String[] args) {
        List<NestedInteger> nestedList = new ArrayList<>();
    }

    public class NestedIterator implements Iterator<Integer> {
        private Queue<Integer> st = new LinkedList();

        public NestedIterator(List<NestedInteger> nestedList) {
            for (NestedInteger val : nestedList) {
                helper(val);
            }
        }

        private void helper(NestedInteger ni) {
            if (ni.isInteger()) {
                st.offer(ni.getInteger());
            } else {
                List<NestedInteger> newList = ni.getList();
                for (NestedInteger it : newList) {
                    helper(it);
                }
            }
        }

        @Override
        public Integer next() {
            return st.poll();
        }

        @Override
        public boolean hasNext() {
            return !st.isEmpty();
        }
    }


    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }
}
