import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.checkValidString("(*()"));
    }

    public boolean checkValidString(String s) {
        Stack<Character> stack = new Stack<>();
        char[] ch = s.toCharArray();
        int i = 0;
        for (i = 0; i < ch.length; i++) {
            if (ch[i] == '(' || ch[i] == '*') {
                stack.push(ch[i]);
            } else {
                if (!stack.isEmpty()) {
                    if (stack.peek() == '(' || stack.peek() == '*') {
                        char temp = stack.pop();
                        if (temp == '(') {

                        } else if (!stack.isEmpty() && stack.peek() == '(') {
                            stack.pop();
                            stack.push(temp);
                        } else if (temp == '*') {

                        } else {
                            return false;
                        }

                    }
                }
            }
        }

        if (!stack.isEmpty() && stack.peek() == '(') return false;
        return true;
    }


}

