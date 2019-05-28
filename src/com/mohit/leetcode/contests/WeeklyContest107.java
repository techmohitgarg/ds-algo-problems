package com.mohit.leetcode.contests;

public class WeeklyContest107 {

    public static void main(String[] args) {
        WeeklyContest107 contest7 = new WeeklyContest107();
        System.out.println(contest7.minFlipsMonoIncr("00110"));
    }


    public boolean isLongPressedName(String name, String typed) {
        if (name.length() == 0 && typed.length() == 0) {
            return false;
        }

        if (typed.length() < name.length()) {
            return false;
        }
        if (name.equals(typed)) {
            return true;
        }
        int i = 0;
        while (i < name.length()) {
            int j = 0;
            while (i < name.length() && j < typed.length()) {
                if (name.charAt(i) == typed.charAt(j)) {
                    i++;
                }
                j++;
            }
            if (i != name.length() && j == typed.length()) {
                return false;
            }
            if (i == name.length()) {
                return true;
            }
        }

        return false;
    }

    public int minFlipsMonoIncr(String A) {
        int globalSum = 0, left = -1, right = -1, localSum = 0, localLeft = -1, localRight = -1;
        for (int i = 0; i < A.length(); i++)
            if (A.charAt(i) == '0') {
                localSum += 1;
                if (localLeft == -1)
                    localLeft = i;
                localRight = i;
                if (localSum > globalSum) {
                    globalSum = localSum;
                    left = localLeft;
                    right = localRight;
                }
            } else {
                localSum -= 1;
                if (localSum < 0) {
                    localSum = 0;
                    localLeft = -1;
                    localRight = -1;
                }
            }

        return globalSum - (left + right);

    }
}

