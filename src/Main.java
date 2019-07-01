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

        //System.out.println(Pattern.matches("[a-fA-F0-9]{4}", "8A2E"));
        System.out.println(main.validIPAddress("2001:0db8:85a3:00000:0:8A2E:0370:7334"));
    }

    public String validIPAddress(String IP) {
        final String IPV4 = "IPv4";
        final String IPV6 = "IPv6";
        final String NOTHING = "Neither";
        if (IP.length() <= 0) {
            return NOTHING;
        }
        if ((IP.charAt(IP.length() - 1) == '.') || (IP.charAt(IP.length() - 1) == ':')) {
            return NOTHING;
        }
        if (isIPV4(IP)) return IPV4;
        if (isIPV6(IP)) return IPV6;
        return NOTHING;
    }

    public boolean isIPV4(String IP) {
        String[] val = IP.split("\\.");
        if (val.length != 4) return false;
        for (int i = 0; i < val.length; i++) {
            if (!isValid(val[i], 1)) return false;
        }
        return true;
    }

    public boolean isIPV6(String IP) {
        String[] val = IP.split(":");
        if (val.length != 8) return false;
        for (int i = 0; i < val.length; i++) {
            if (val[i].length() == 0) return false;
            if (!isValid(val[i], 2)) return false;
        }
        return true;
    }

    public boolean isValid(String value, int b) {
        if (b == 1) {
            if (value.length() == 0 || value.length() > 3 || value.length() > 1 && value.charAt(0) == '0') {
                return false;
            }
            for (char s : value.toCharArray()) {
                if (s >= 'A' && s <= 'Z' || s >= 'a' && s <= 'z') {
                    return false;
                }
            }
            if (Integer.parseInt(value) > 255) {
                return false;
            }
        } else if (b == 2) {
            if (value.length() > 4 || value.charAt(0) == '-' || value.charAt(0) == '+') {
                return false;
            }
            for (char s : value.toCharArray()) {
                if ((s > 'F' && s <= 'Z') || (s > 'f' && s <= 'z')) {
                    return false;
                }
            }
        }
        return true;
    }
}

