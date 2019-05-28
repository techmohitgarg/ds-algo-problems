package com.mohit.programmingtest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class DatamaticsDigitalTest {

    public static void main(String[] args) {

        String[] votes = {"Joe",
                "Mary",
                "Mary",
                "Mary",
        };
        System.out.println(electionWinner(votes));
    }

    static String electionWinner(String[] votes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < votes.length; i++) {
            map.put(votes[i], map.getOrDefault(votes[i], 0) + 1);
        }

        int max = -1;
        String value = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (max == -1) {
                max = val;
                value = key;
            } else if (max <= val) {
                if (max == val && key.charAt(key.length() - 1) < value.charAt(value.length() - 1)) {
                    value = key;
                } else if (max < val) {
                    max = val;
                    value = key;
                }
            }
        }
        return value;
    }

    public static int maxMoves(String s, String t) {
        int count = 0;
        while (s.contains(t)) {
            s = s.replace(Pattern.quote(t), "");
            count++;
        }
        return count;
    }
}
