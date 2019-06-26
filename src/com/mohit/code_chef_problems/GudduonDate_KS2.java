package com.mohit.code_chef_problems;

import java.util.Scanner;

public class GudduonDate_KS2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            String val = sc.next();
            String result = getValue(val);
            System.out.println(result);
            t--;
        }

    }

    public static String getValue(String num) {
        String val = num + "0";
        char[] ch = val.toCharArray();
        long sum = 0;
        int j = 0;
        while (j < ch.length) {
            sum += ch[j] - '0';
            j++;
        }
        int i = 0;
        while (i < 10 && ((sum + i) % 10) != 0) {
            i++;
        }
        if (((sum + i) % 10) == 0) {
            return num + i;
        }
        return "";
    }
}
