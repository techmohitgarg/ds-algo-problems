package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/count-binary-substrings/
 */
public class CountBinarySubstrings {

    public static void main(String[] args) {
        CountBinarySubstrings main = new CountBinarySubstrings();
        System.out.println(main.countBinarySubstrings("110001111000000"));
    }

    public int countBinarySubstrings(String s) {
        int count = 0;
        int lastCount = 0;
        int maxCount = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == s.charAt(i - count)) {
                count++;
                i++;
            } else {
                maxCount += Math.min(count, lastCount);
                lastCount = count;
                count = 0;
            }
        }
        maxCount += Math.min(count, lastCount);
        return maxCount;
    }
   /* public int countBinarySubstrings(String s) {
        List<Integer> group = new ArrayList<>();
        int count = 0;
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == s.charAt(i - count)) {
                count++;
                i++;
            } else {
                group.add(count);
                count = 0;
            }
        }
        if (count > 0) {
            group.add(count);
            count = 0;
        }
        for (int i = 0; i < group.size() - 1; i++) {
            count += Math.min(group.get(i), group.get(i + 1));
        }
        return count;
    }*/
}
