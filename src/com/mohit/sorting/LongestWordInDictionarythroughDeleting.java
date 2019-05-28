package com.mohit.sorting;

import java.util.ArrayList;
import java.util.List;

public class LongestWordInDictionarythroughDeleting {
    public static void main(String[] args) {
        LongestWordInDictionarythroughDeleting deleting = new LongestWordInDictionarythroughDeleting();
        String s = "abpcplea";
        List<String> d = new ArrayList<>();
        d.add("ale");
        d.add("apple");
        d.add("monkey");
        d.add("plea");
        String result = deleting.findLongestWord(s, d);
        System.out.println(result);
    }

    public String findLongestWord(String s, List<String> d) {
        if (s.length() <= 0 || d.size() <= 0) {
            return "";
        }

        int max = 0;
        int index = -1;
        for (int i = 0; i < d.size(); i++) {
            String dIndex = d.get(i);
            int k = 0;
            for (int j = 0; j < s.length() && k < dIndex.length(); j++) {
                char c = dIndex.charAt(k);
                if (!s.contains(s + "")) {
                    break;
                }
                if (s.charAt(j) == dIndex.charAt(k)) {
                    k++;
                }
            }
            if (k == dIndex.length()) {
                if (max <= k) {
                    if (max == k) {
                        if (!IsChange(d.get(index), d.get(i))) {
                            max = k;
                            index = i;
                        }
                    } else {
                        max = k;
                        index = i;
                    }

                }

            }

        }
        return index == -1 ? "" : d.get(index);
    }

    public boolean IsChange(String a, String b) {
        int i = 0;
        int j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
                continue;
            }
            if (a.charAt(i) < b.charAt(j)) {
                return true;
            } else {
                return false;
            }

        }
        return true;
    }
}