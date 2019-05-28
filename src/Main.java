public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.search(new int[]{4, 2, 1}, 2));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 0) {
            return false;
        }

        int piovt = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                piovt = i;
                break;
            }
        }
        // check if pivot
        if (piovt == -1) {
            return binarySearch(nums, 0, nums.length - 1, target) == -1 ? false : true;
        }
        if (nums[piovt] == target) {
            return true;
        }

        if (nums[0] > target) {
            return binarySearch(nums, piovt+1, nums.length - 1, target) == -1 ? false : true;
        }
        return binarySearch(nums, 0, piovt, target) == -1 ? false : true;
    }

    public int binarySearch(int[] nums, int left, int right, int target) {
        if (left <= right) {
            int m = (right + left) / 2;
            if (nums[m] == target) {
                return m;
            }
            if (nums[m] > target) {
                return binarySearch(nums, left, m - 1, target);
            } else {
                return binarySearch(nums, m + 1, right, target);
            }
        }
        return -1;
    }


}
