package com.mohit.code_chef_problems;

import java.util.Scanner;

public class TWOSTR_ChefandtheWildcardMatching {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t > 0) {
            String s1 = s.next();
            String s2 = s.next();
            int i = 0;
            while (i < s1.length() && i < s2.length()) {
                if (s1.charAt(i) != s2.charAt(i) && s1.charAt(i) != '?' && s2.charAt(i) != '?') {
                    break;
                }
                i++;
            }
            if (i == s1.length() && i == s2.length()) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }

            t--;
        }
    }
}
