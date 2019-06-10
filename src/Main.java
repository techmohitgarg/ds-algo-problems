/*
https://leetcode.com/problems/valid-palindrome-ii/
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.validPalindrome("abca"));
    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {

            } else {
                l++;
                r--;
            }

        }
        return true;
    }

}
/*
Today Target : 10 Problems

1. https://leetcode.com/problems/reverse-string-ii/
2.https://leetcode.com/problems/student-attendance-record-i/
3.https://leetcode.com/problems/reverse-words-in-a-string-iii/
4.https://leetcode.com/problems/robot-return-to-origin/
5.
 */
