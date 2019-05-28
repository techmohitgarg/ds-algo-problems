package com.mohit.code_chef_problems;

import java.util.Scanner;

public class FLOW010_IdandShip {

    public static void main(String[] args) throws java.lang.Exception {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            char c = sc.next().charAt(0);
            if (c == 'B' || c == 'b') {
                System.out.println("BattleShip");
            } else if (c == 'C' || c == 'c') {
                System.out.println("Cruiser");
            } else if (c == 'D' || c == 'd') {
                System.out.println("Destroyer");
            } else if (c == 'F' || c == 'f') {
                System.out.println("Frigate");
            }
            t--;
        }


    }
}
