import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
https://leetcode.com/problems/unique-email-addresses/
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.multiply("9", "9"));
    }


    public String multiply(String num1, String num2) {
        if (num1.length() == 0 && num2.length() == 0) {
            return "";
        }
        if (num1.length() == 0) {
            return num2;
        }
        if (num2.length() == 0) {
            return num1;
        }

        int[] multiply = new int[num1.length() + num2.length()];
        int m = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            int carry = 0;
            int n = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int num = ((num2.charAt(j) - '0') * a) + carry + multiply[m + n];
                multiply[m + n] = num % 10;
                carry = num / 10;
                n++;
            }
            if (carry > 0) {
                multiply[m + n] = carry;
            }
            m++;
        }

        int num = multiply.length - 1;
        while (num > 0 && multiply[num] == 0) {
            num--;
        }
        StringBuilder builder = new StringBuilder();
        while (num >= 0) {
            builder.append(multiply[num]);
            num--;
        }
        return builder.toString();
    }

}
