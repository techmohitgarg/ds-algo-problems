package com.mohit.code_chef_problems;

import java.util.Scanner;

public class PROXYC_ChefandProxy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            int p = 0;
            char[] ch = sc.next().toCharArray();
            for (int i = 0; i < n; i++) {
                if (ch[i] == 'P') {
                    ++p;
                }
            }

            double req = .75 * n;
            double diff = req - p;
            if (diff <= 0) {
                System.out.println(0);
            } else if (ch.length <= 4) {
                System.out.println(-1);
            } else {
                int proxy = 0;
                int flag = 0;
                for (int i = 2; i < ch.length - 2; i++) {
                    if (diff <= 0) {
                        flag = 1;
                        System.out.println(proxy);
                        break;
                    }
                    if (ch[i] == 'A') {
                        if ((ch[i - 1] == 'P' || ch[i - 2] == 'P') && (ch[i + 1] == 'P' || ch[i + 2] == 'P')) {
                            proxy++;
                            ++p;
                        }
                    }
                    diff = req - p;
                }
                if (flag == 0) {
                    if (diff <= 0) {
                        System.out.println(proxy);
                    } else {
                        System.out.println(-1);
                    }
                }
            }
            t--;
        }
    }

}
