package com.mohit.strings.easy;

/*
https://leetcode.com/problems/add-binary/submissions/
 */
public class AddBinary {

    public static void main(String[] args) {
        AddBinary main = new AddBinary();
        System.out.println(main.addBinary("0", "0"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder builder = new StringBuilder();
        while (i >= 0 || j >= 0) {
            int sum = carry;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }

            if (sum > 2) {
                carry = 0;
                builder.append(1);
            } else if (sum == 2) {
                carry = 1;
                builder.append(0);
            } else {
                carry = 0;
                builder.append(sum);
            }
        }
        if (carry == 1) {
            builder.append(1);
        }
        return builder.reverse().toString();
    }

}
