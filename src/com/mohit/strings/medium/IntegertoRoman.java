/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.strings.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Mohit Garg
 */
public class IntegertoRoman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegertoRoman problems = new IntegertoRoman();
        System.out.println(problems.intToRoman(58));
    }

    public String intToRoman(int num) {
        String[][] val = {
            {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
            {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
            {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
            {"", "M", "MM", "MMM", "", "", "", "", "", ""}
        };
        return val[3][(num / 1000)] + val[2][(num % 1000) / 100] + val[1][(num % 100) / 10] + val[0][(num % 10)];
    }
}
