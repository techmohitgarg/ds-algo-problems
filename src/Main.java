import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.numDecodings("12"));
    }

    public int numDecodings(String s) {
        if (s.charAt(0) == '0' || s.length() == 0) {
            return 0;
        }
        int[] count = new int[s.length() + 1];
        count[0] = 1;
        count[1] = 1;
        for (int i = 2; i < count.length; i++) {
            count[i] = 0;
            if (s.charAt(i - 1) > '0') {
                count[i] = count[i - 1];
            }

            if (s.charAt(i - 2) == '1' || s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7') {
                count[i] += count[i - 2];
            }
        }
        return count[count.length - 1];
    }


}

