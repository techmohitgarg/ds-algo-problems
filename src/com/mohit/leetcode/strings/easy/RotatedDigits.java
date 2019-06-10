package com.mohit.leetcode.strings.easy;

/*
https://leetcode.com/problems/rotated-digits/
 */
public class RotatedDigits {

    public static void main(String[] args) {
        RotatedDigits main = new RotatedDigits();
        System.out.println(main.rotatedDigits(10));
    }

    public int rotatedDigits(int N) {
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (isValidNumber(i)) {
                count++;
            }
        }
        return count;
    }

    public boolean isValidNumber(int n) {
        boolean isChange = false;
        while (n > 0) {
            int temp = n % 10;
            if (temp == 2 || temp == 5 || temp == 6 || temp == 9) {
                isChange = true;
            } else if (temp == 3 || temp == 4 || temp == 7) {
                return false;
            }
            n = n / 10;
        }
        return isChange;
    }


}
