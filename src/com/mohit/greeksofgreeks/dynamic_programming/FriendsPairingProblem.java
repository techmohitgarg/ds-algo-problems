package com.mohit.greeksofgreeks.dynamic_programming;

public class FriendsPairingProblem {

    public static void main(String[] args) {
        FriendsPairingProblem problem = new FriendsPairingProblem();
        System.out.println(problem.countFriendsPairings(4));
    }

    /**
     * @param n no of friends
     * @return count the no of pairs can be make
     * TC : O(2^n)
     * SC : o(n) recursive stack will take the n space
     */
    public int countFriendsPairings_(int n) {
        if (n <= 2) {
            return n;
        }

        int singlePair = countFriendsPairings_(n - 1);
        int otherPair = (n - 1) * countFriendsPairings_(n - 2);

        return singlePair + otherPair;
    }

    /**
     * @param n no of friends
     * @return count the no of pairs can be make
     * TC : O(n)
     * SC : o(n+1)
     */
    public int countFriendsPairings(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
        }
        return dp[n];
    }


}
