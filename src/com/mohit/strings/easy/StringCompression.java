package com.mohit.strings.easy;

public class StringCompression {

    public static void main(String[] args) {
        StringCompression main = new StringCompression();
        System.out.println(main.compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'c'}));
    }

    public int compress(char[] chars) {
        int totalCount = 0;
        int k = 0;
        for (int i = 0; i < chars.length;) {
            int count = 0;
            char currentChar = chars[i];
            while (i < chars.length && (count == 0 || chars[i] == chars[i - count])) {
                count++;
                i++;
            }
            int curentPosition = k;
            if (count == 1) {
                totalCount += 1;
                k++;
            } else if (count < 10) {
                chars[k + 1] = Character.forDigit(count, 10);
                totalCount += 2;
                k += 2;
            } else {
                while (count >= 10) {
                    int temp = count < 10 ? count : count / 10;
                    char ch = Character.forDigit(temp, 10);
                    chars[k + 1] = (char) ch;
                    count = count % 10;
                    k++;
                    totalCount += 1;
                }
                chars[k + 1] = Character.forDigit(count, 10);
                totalCount += 2;
                k += 2;
            }
            count = 0;
            chars[curentPosition] = currentChar;
        }
        return totalCount;
    }

}
