/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mohit Garg
 */
public class CompareVersionNumbers {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CompareVersionNumbers problems = new CompareVersionNumbers();
        String version1 = "1";
        String version2 = "1.1";
        System.out.println(problems.compareVersion(version1, version2));
    }
//If version1 > version2 return 1; if version1 < version2 return -1;otherwise return 0

    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 && version2.length() == 0) {
            return 0;
        }
        if (version1.length() == 0) {
            return -1;
        }
        if (version2.length() == 0) {
            return 1;
        }

        int i = 0;
        int j = 0;
        int v1 = 0;
        int v2 = 0;
        while (i < version1.length() && j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) != '.') {
                v1 = 10 * v1 + (version1.charAt(i) - '0');
                i++;
            }
            while (j < version2.length() && version2.charAt(j) != '.') {
                v2 = 10 * v2 + (version2.charAt(j) - '0');
                j++;
            }
            if (v1 < v2) {
                return -1;
            } else if (v1 > v2) {
                return 1;
            } else {
                v1 = 0;
                v2 = 0;
                i++;
                j++;
            }
        }
        while (i < version1.length()) {
            if (version1.charAt(i) == '.') {
                if (v1 > 0) {
                    return 1;
                } else {
                    v1 = 0;
                    i++;
                }
            } else {
                v1 = 10 * v1 + (version1.charAt(i) - '0');
                i++;
            }

        }
        if (v1 > 0) {
            return 1;
        }
        while (j < version2.length()) {
            if (version2.charAt(j) == '.') {
                if (v2 > 0) {
                    return -1;
                } else {
                    v2 = 0;
                    j++;
                }
            } else {
                v2 = 10 * v2 + (version2.charAt(j) - '0');
                j++;
            }
        }
        if (v2 > 0) {
            return -1;
        }
        return 0;
    }
}
