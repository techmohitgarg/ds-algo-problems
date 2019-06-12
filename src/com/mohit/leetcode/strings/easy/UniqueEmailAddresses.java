package com.mohit.leetcode.strings.easy;

import java.util.HashSet;
import java.util.Set;

/*
https://leetcode.com/problems/unique-email-addresses/
 */
public class UniqueEmailAddresses {

    public static void main(String[] args) {
        UniqueEmailAddresses main = new UniqueEmailAddresses();
        System.out.println(main.numUniqueEmails(new String[]{"testemail@leetcode.com", "testemail1@leetcode.com", "testemail+david@lee.tcode.com"}));
    }

    public int numUniqueEmails(String[] emails) {
        if (emails.length == 0) {
            return 0;
        }

        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String temp = emails[i];

            StringBuilder sb = new StringBuilder();
            int j = 0;
            while (j < temp.length() && temp.charAt(j) != '@' && temp.charAt(j) != '+') {
                if (temp.charAt(j) != '.') {
                    sb.append(temp.charAt(j));
                }
                j++;
            }
            set.add(sb.toString() + "" + temp.substring(temp.indexOf('@')));
        }
        return set.size();
    }
}
