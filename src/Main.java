import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Input: ["23:59","00:00"]
Output: 1
 */
public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<String> list = new ArrayList<>();
        list.add("23:59");
        list.add("11:05");
        System.out.println(main.findMinDifference(list));
    }

    public int findMinDifference(List<String> timePoints) {
        int mindiff = Integer.MAX_VALUE;
        int n = timePoints.size();
        Collections.sort(timePoints);
        for (int i = 0; i < timePoints.size(); i++) {
            int diff = Math.abs(timeDiff(timePoints.get((i - 1 + n) % n), timePoints.get(i)));
            diff = Math.min(diff, 1440 - diff);
            mindiff = Math.min(mindiff, diff);
        }
        return mindiff;
    }

    private int timeDiff(String s1, String s2) {
        try {
            Date dt1 = new SimpleDateFormat("HH:mm").parse(s1);
            Date dt2 = new SimpleDateFormat("HH:mm").parse(s2);
            long diff = Math.abs(dt2.getTime() - dt1.getTime());
            long diffMinutes = (diff / 1000) / 60;
            return (int) diffMinutes;
        } catch (ParseException e) {
        }
        return 0;
    }
}

