import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.summaryRanges(new int[]{0,1,2,5,6,7}));
    }
   public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int left = 0;
        int start = 0;
        while (left < nums.length) {
            start = nums[left];
            while (left < nums.length - 1 && nums[left] + 1 == nums[left + 1]) {
                left++;
            }
            if (start == nums[left]) {
                list.add(start + "");
            } else {
                list.add(start + "->" + nums[left]);
            }
            left++;
        }
        return list;

    }

}
