/*
 https://leetcode.com/problems/zigzag-conversion/solution/
 */
package com.mohit.leetcode.strings.medium;

/**
 * @author Mohit Garg
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        ZigZagConversion problems = new ZigZagConversion();
        String string = "AB";
        int n = 1;
        System.out.println(problems.convert(string, n));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        StringBuilder ret = new StringBuilder();
        int n = s.length();
        int cycleLen = 2 * numRows - 2;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < n; j += cycleLen) {
                ret.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
                    ret.append(s.charAt(j + cycleLen - i));
            }
        }
        return ret.toString();
    }
    /*public String convert(String s, int numRows) {

        if (numRows == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }*/

   /* public String convert(String s, int numRows) {
        HashMap<Integer, StringBuilder> set = new HashMap<>();
        int i = 1;
        boolean up = false;
        for (char c : s.toCharArray()) {
            StringBuilder builder = new StringBuilder();
            if (set.containsKey(i)) {
                builder.append(set.get(i));
                builder.append(c);
            } else {
                builder.append(c);
            }
            set.put(i, builder);
            if (up) {
                i--;
            } else {
                i++;
            }
            if (i == numRows) {
                up = true;
            }
            if (i == 1) {
                up = false;
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int key : set.keySet()) {
            builder.append(set.get(key));
        }

        return builder.toString();
    }*/

}
