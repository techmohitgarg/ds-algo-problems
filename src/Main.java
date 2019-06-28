import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Example 1:

Input: version1 = "0.1", version2 = "1.1"
Output: -1
Example 2:

Input: version1 = "1.0.1", version2 = "1"
Output: 1
Example 3:

Input: version1 = "7.5.2.4", version2 = "7.5.3"
Output: -1
Example 4:

Input: version1 = "1.01", version2 = "1.001"
Output: 0
Explanation: Ignoring leading zeroes, both “01” and “001" represent the same number “1”
Example 5:

Input: version1 = "1.0", version2 = "1.0.0"
Output: 0
Explanation: The first version number does not have a third level revision number, which means its third level revision number is default to "0"
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.compareVersion("111111111111111111112.0", "111111111111111111112.1"));
    }

    public int compareVersion(String version1, String version2) {
        if (version1.length() == 0 && version2.length() == 0) return 0;
        if (version1.length() == 0) return -1;
        if (version2.length() == 0) return 1;
        int i = 0;
        int j = 0;
        while (i < version1.length() || j < version2.length()) {
            while (i < version1.length() && version1.charAt(i) == '0') i++;
            while (j < version2.length() && version2.charAt(j) == '0') j++;
            while (i < version1.length() && version1.charAt(i) != '.' || j < version2.length() && version2.charAt(j) != '.') {
                int b1 = 0;
                if (i < version1.length()) {
                    b1 = version1.charAt(i) - '0';
                }

                int b2 = 0;
                if (j < version2.length()) {
                    b2 = version2.charAt(j) - '0';
                }
                if (b1 > b2) {
                    return 1;
                }
                if (b1 < b2) {
                    return -1;
                }
                i++;
                j++;
            }

            i++;
            j++;
        }
        return 0;
    }

}

