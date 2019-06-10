package com.mohit.strings.easy;

public class DetectCapital {

    public static void main(String[] args) {
        DetectCapital main = new DetectCapital();
        System.out.println(main.detectCapitalUse("abaababaab"));
    }

    public boolean detectCapitalUse(String word) {
        if (word.length() == 0) {
            return false;
        }
        boolean isFirstCaptial = (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') ? true : false;
        int countCap = 0;
        int countSmall = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                countSmall++;
            }
            if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                countCap++;
            }
            if ((countCap > 1 && countSmall > 0)) {
                return false;
            }
        }
        if ((isFirstCaptial && countSmall == word.length() - 1) || countCap == word.length() || countSmall == word.length()) {
            return true;
        }
        return false;
    }

}
