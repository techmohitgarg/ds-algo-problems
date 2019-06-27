/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mohit Garg
 */
public class GroupAnagrams {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GroupAnagrams problems = new GroupAnagrams();
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        HashMap<String, List<String>> hm = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String first = strs[i];
            char[] temp = first.toCharArray();
            Arrays.sort(temp);
            String tempNew = String.valueOf(temp);
            if (!hm.containsKey(tempNew)) {
                List<String> ses = new ArrayList<>();
                ses.add(first);
                hm.put(tempNew, ses);
            } else {
                List<String> ses = hm.get(tempNew);
                ses.add(first);
                hm.put(tempNew, ses);
            }
        }
        for (Map.Entry<String, List<String>> entry : hm.entrySet()) {
            List<String> value = entry.getValue();
            list.add(value);
        }
        return list;
    }
}
