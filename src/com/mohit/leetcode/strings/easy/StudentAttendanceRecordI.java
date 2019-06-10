package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/student-attendance-record-i/
 */
public class StudentAttendanceRecordI {

    public static void main(String[] args) {
        StudentAttendanceRecordI main = new StudentAttendanceRecordI();
        System.out.println(main.checkRecord("PPALLL"));
    }

    public boolean checkRecord(String s) {
        if (s.length() == 0) {
            return false;
        }
        int i = 0;
        int a = 0;
        while (i < s.length()) {
            if (s.charAt(i) == 'A') {
                a++;
            } else if (i > 1 && (s.charAt(i) == 'L' && s.charAt(i - 1) == 'L') && (s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L')) {
                return false;
            }
            if (a > 1) {
                return false;
            }
            i++;
        }
        return true;
    }

}
