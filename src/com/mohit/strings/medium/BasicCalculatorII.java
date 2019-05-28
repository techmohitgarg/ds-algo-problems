/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.strings.medium;

import java.util.Stack;

/**
 *
 * @author Mohit Garg
 */
public class BasicCalculatorII {

    public static void main(String[] args) {
        BasicCalculatorII bcii = new BasicCalculatorII();
        System.out.println(bcii.calculate("100000000/1/2/3/4/5/6/7/8/9/10"));
    }
//"100000000/1/2/3/4/5/6/7/8/9/10"

    public int calculate(String s) {
        s = s.trim();
        Stack<Integer> number = new Stack<>();
        Stack<Character> signs = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                continue;
            }
            if (Character.isDigit(s.charAt(i))) {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = 10 * num + (s.charAt(i) - '0');
                    i++;
                }
                number.push(num);
                i--;
            } else {
                while (!signs.isEmpty() && getSign(signs.peek()) >= getSign(s.charAt(i)) && !number.isEmpty()) {
                    char sign = signs.pop();
                    int num1 = number.pop();
                    int num2 = number.pop();
                    switch (sign) {
                        case '+':
                            number.push(num2 + num1);
                            break;
                        case '-':
                            number.push(num2 - num1);
                            break;
                        case '*':
                            number.push(num2 * num1);
                            break;
                        case '/':
                            if (num1 == 0) {
                                number.push(0);
                            } else {
                                number.push(num2 / num1);
                            }
                            break;
                    }
                }
                signs.push(s.charAt(i));
            }
        }
        while (!signs.isEmpty()) {
            int num1 = number.pop();
            int num2 = number.pop();
            switch (signs.pop()) {
                case '+':
                    number.push(num2 + num1);
                    break;
                case '-':
                    number.push(num2 - num1);
                    break;
                case '*':
                    number.push(num2 * num1);
                    break;
                case '/':
                    if (num1 == 0) {
                        number.push(0);
                    } else {
                        number.push(num2 / num1);
                    }

                    break;
            }
        }

        return number.isEmpty() ? 0 : number.pop();
    }

    public int getSign(char c) {
        if (c == '+') {
            return 1;
        }
        if (c == '-') {
            return 1;
        }
        if (c == '*') {
            return 2;
        }
        if (c == '/') {
            return 2;
        }
        return -1;
    }
}
