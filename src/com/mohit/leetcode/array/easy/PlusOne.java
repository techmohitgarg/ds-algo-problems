package com.mohit.leetcode.array.easy;/*Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:
Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.

Example 2:
Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.

Link : https://leetcode.com/problems/plus-one/description/
*/

import java.util.ArrayList;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne p = new PlusOne();
        int[] arr = {0, 3, 7, 6, 4, 0, 5, 5, 5};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            A.add(arr[i]);
        }
        System.out.println(p.plusOne(A));
    }

    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int temp = digits[i] + carry;
            carry = temp / 10;
            digits[i] = temp % 10;
        }
        int[] plusOne = new int[digits.length + 1];
        if (carry == 1) {
            plusOne[0] = carry;
            return plusOne;
        }
        return digits;
    }

    public ArrayList<Integer> plusOne(ArrayList<Integer> A) {
        int carry = 1;
        for (int i = A.size() - 1; i >= 0; i--) {
            int temp = A.get(i) + carry;
            carry = temp / 10;
            A.set(i, temp % 10);
        }
        if (carry == 1) {
            A.add(0, 1);
            return A;
        }

        // remove leading zero
        while (A.size() > 0 && A.get(0) == 0) {
            A.remove(0);
        }

        return A;
    }
}