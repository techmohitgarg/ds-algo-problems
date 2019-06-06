import com.mohit.sorting.PrintArray;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.canConstruct("a", "b"));
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> magM = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            if (!magM.containsKey(c)) {
                magM.put(c, 1);
            } else {
                magM.put(c, magM.get(c) + 1);
            }
        }
        for (char c : ransomNote.toCharArray()) {
            if (!magM.containsKey(c)) {
                return false;
            }
            int newCount = magM.get(c) - 1;
            if (newCount < 0) {
                return false;
            }
            magM.put(c, newCount);
        }
        return true;
    }
}
