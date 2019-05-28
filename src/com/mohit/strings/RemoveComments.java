package com.mohit.strings;

import java.util.ArrayList;
import java.util.List;

public class RemoveComments {

    public static void main(String[] args) {
        RemoveComments comments = new RemoveComments();
        String[] temp = {"a/*/b//*c", "blank", "d/*/e*//f"};
        System.out.printf(comments.removeComments(temp).toString());
    }

    public List<String> removeComments(String[] source) {
        List<String> res = new ArrayList<String>();
        String tmp = "";
        boolean mulopen = false;
        for (int i = 0; i < source.length; i++) {
            for (int j = 0; j < source[i].length(); j++) {
                if (j < source[i].length() - 1 && source[i].charAt(j) == '/' && source[i].charAt(j + 1) == '/' && !mulopen)
                    break;
                else if (j < source[i].length() - 1 && source[i].charAt(j) == '/' && source[i].charAt(j + 1) == '*' && !mulopen) {
                    mulopen = true;
                    j++;
                } else if (!mulopen)
                    tmp += source[i].charAt(j);
                else if (j < source[i].length() - 1 && source[i].charAt(j) == '*' && source[i].charAt(j + 1) == '/' && mulopen) {
                    mulopen = false;
                    j++;
                }


            }
            if (!mulopen && !tmp.equals("")) {
                res.add(tmp);
                tmp = "";
            }
        }
        return res;
    }
}
