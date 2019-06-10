package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/student-attendance-record-i/
 */
public class RobotReturntoOrigin {

    public static void main(String[] args) {
        RobotReturntoOrigin main = new RobotReturntoOrigin();
        System.out.println(main.judgeCircle("LL"));
    }

    public boolean judgeCircle(String moves) {
        int left = 0;
        int up = 0;
        int i = 0;
        while (i < moves.length()) {
            char step = moves.charAt(i);
            if (step == 'L') {
                left++;
            } else if (step == 'R') {
                left--;
            } else if (step == 'U') {
                up--;
            } else if (step == 'D') {
                up++;
            }
            i++;
        }
        return (left == 0 && up == 0);
    }
}
