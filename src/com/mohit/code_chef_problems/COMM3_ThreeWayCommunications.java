package com.mohit.code_chef_problems;

import java.util.Scanner;

public class COMM3_ThreeWayCommunications {
    /*

     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            //Communication Range
            int r = sc.nextInt();
            //The Chef
            int cx = sc.nextInt();
            int cy = sc.nextInt();
            //The Server
            int sx = sc.nextInt();
            int sy = sc.nextInt();
            //The Sous Chef
            int sCx = sc.nextInt();
            int sCy = sc.nextInt();
            /*
                {Distance formula}=Distance between two points P(x1, y1) and Q(x2, y2) is given by:
                d(P, Q) = p(x2 − x1)2 + (y2 − y1)2
                Explanations There should be one common person for communications like
                1 ab or bc = b is common
                2 bc or ca = c is common
                3 ca or ab = a is common
            */
            double ab = Math.sqrt(Math.pow((sx - cx), 2) + Math.pow((sy - cy), 2));
            double bc = Math.sqrt(Math.pow((cx - sCx), 2) + Math.pow((cy - sCy), 2));
            double ca = Math.sqrt(Math.pow((sCx - sx), 2) + Math.pow((sCy - sy), 2));
            if ((ab <= r && (bc <= r || ca <= r)) ||
                    (bc <= r && (ab <= r || ca <= r)) ||
                    (ca <= r && (bc <= r || ab <= r))) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
            t--;
        }
    }
}
