/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mohit.leetcode.strings.medium;

/**
 *
 * @author Mohit Garg
 */
public class ValidateIPAddress {

    public static void main(String[] args) {
        ValidateIPAddress problems = new ValidateIPAddress();
        String IP = "20EE:FFb8:85a3:0:0:8A2E:0370:7334";
        System.out.println(problems.validIPAddress(IP));

    }

    public String validIPAddress(String IP) {
        if (IP.length() <= 0) {
            return getIpAddressType(null);
        }
        boolean isIp4 = false;
        boolean isIp6 = false;
        if (IP.contains(".")) {
            isIp4 = true;
            isIp6 = false;
        }
        if (IP.contains(":")) {
            isIp6 = true;
            isIp4 = false;
        }

        // check length
        if ((isIp4 && !isIp6 && IP.length() < 7) || (isIp6 && !isIp4 && IP.length() < 15) || IP.length() > 39) {
            return getIpAddressType(null);
        }
        if ((IP.charAt(IP.length() - 1) == '.') || (IP.charAt(IP.length() - 1) == ':')) {
            return getIpAddressType(null);
        }
        String[] ipAddress;
        if (isIp4) {
            ipAddress = IP.split("\\.");
            if (ipAddress.length != 4) {
                return getIpAddressType(null);
            }
        } else {
            ipAddress = IP.split(":");
            if (ipAddress.length != 8) {
                return getIpAddressType(null);
            }
        }

        boolean isCheck = true;
        for (int i = 0; i < ipAddress.length; i++) {
            String value = ipAddress[i];
            if (value.length() == 0) {
                return getIpAddressType(null);
            }
            if (isIp4) {
                if (((value.length() > 1 && value.charAt(0) == '0') || value.charAt(0) == '-' || value.charAt(0) == '+')) {
                    return getIpAddressType(null);
                }
                for (char s : value.toCharArray()) {
                    if (s >= 'A' && s <= 'Z' || s >= 'a' && s <= 'z') {
                        return getIpAddressType(null);
                    }
                }
                if (Integer.parseInt(value) > 255) {
                    return getIpAddressType(null);
                }
            } else {
                if (value.length() > 4 || value.charAt(0) == '-' || value.charAt(0) == '+') {
                    return getIpAddressType(null);
                }
                for (char s : value.toCharArray()) {
                    if ((s > 'F' && s <= 'Z') || (s > 'f' && s <= 'z')) {
                        return getIpAddressType(null);
                    }
                }
            }
        }

        if (isCheck) {
            if (isIp4) {
                return getIpAddressType(1);
            } else {
                return getIpAddressType(2);
            }
        }
        return getIpAddressType(null);
    }

    private String getIpAddressType(Integer isIP4) {
        return isIP4 == null ? "Neither" : (isIP4 == 1 ? "IPv4" : "IPv6");
    }


   /* public String validIPAddress(String IP) {
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
    }*/
}
