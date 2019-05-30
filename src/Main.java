import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.findPeakElement(new int[]{1, 2, 3, 1}));
    }

    public int findPeakElement(int[] nums) {
        int i;
        if (nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            return 0;
        }
        for (i = 0; i < nums.length; i++) {
            if ((i == 0 && nums[i] >= nums[i + 1]) || (i == nums.length - 1 && nums[i - 1] <= nums[i])) {
                return i;
            } else if (i > 0 && i <= nums.length - 1 && nums[i - 1] <= nums[i] && nums[i] >= nums[i + 1]) {
                return i;
            }
        }
        return -1;
    }

}
