/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.strings.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author Mohit Garg
 */
public class RestoreIPAddresses {

    public static void main(String[] args) {
        RestoreIPAddresses bcii = new RestoreIPAddresses();
        System.out.println(bcii.restoreIpAddresses("25525511135"));
    }

    //25525511135
    // [“255.255.11.135”, “255.255.111.35”]
    public List<String> restoreIpAddresses(String A) {
        int len = A.length();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4 && i < len - 2; i++) {
            for (int j = i + 1; j < i + 4 && j < len - 1; j++) {
                for (int k = j + 1; k < j + 4 && k < len; k++) {
                    String s1 = A.substring(0, i), s2 = A.substring(i, j), s3 = A.substring(j, k), s4 = A.substring(k, len);
                    if (isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)) {
                        list.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }

        }

        return list;
    }

    public boolean isValid(String value) {
        if (value.length() == 0 || value.length() > 3 || value.length() > 1 && value.charAt(0) == '0' || Integer.parseInt(value) > 255) {
            return false;
        }
        return true;
    }
}
