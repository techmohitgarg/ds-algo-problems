/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 *
 * @author Mohit Garg
 */
public class LetterCombinationsofaPhoneNumber {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber problems = new LetterCombinationsofaPhoneNumber();
        System.out.println(problems.letterCombinations("0"));

    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        Deque<String> queue = new ArrayDeque<>();
        for (int i = 0; i < digits.length(); i++) {
            String value = getDigitValue(digits.charAt(i));
            if (value.length() == 0) {
                break;
            }
            String val = "";
            int size = queue.size();
            while (queue.isEmpty() || size > 0) {
                if (queue.size() > 0) {
                    val = queue.poll();
                }
                for (int j = 0; j < value.length(); j++) {
                    if (i == 0) {
                        queue.addLast(String.valueOf(value.charAt(j)));
                    } else {
                        queue.addLast(String.valueOf(val + value.charAt(j)));
                    }
                }
                if (size != 0) {
                    size--;
                }
            }
        }
        while (!queue.isEmpty()) {
            list.add(queue.poll());
        }
        return list;
    }

    private String getDigitValue(char ch) {
        switch (ch) {
            case '2':
                return "abc";
            case '3':
                return "def";
            case '4':
                return "ghi";
            case '5':
                return "jkl";
            case '6':
                return "mno";
            case '7':
                return "pqrs";
            case '8':
                return "tuv";
            case '9':
                return "wxyz";

        }
        return "";
    }
}
