package com.mohit.interviewbit.array;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        SpiralOrderMatrix matrix = new SpiralOrderMatrix();
        int[] nums = matrix.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(nums);
    }

    public int[] spiralOrder(final int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int tL = 0;
        int tR = matrix[0].length;
        int bL = 0;
        int bR = matrix.length;
        int count = 0;
        int[] nums = new int[matrix.length * matrix[0].length];
        while (tL < tR && bL < bR) {
            for (int i = tL; i < tR; i++) {
                nums[count++] = matrix[tL][i];
            }
            tL++;
            for (int i = tL; i < bR; i++) {
                nums[count++] = matrix[i][tR - 1];
            }
            tR--;
            if (tL < bR) {
                for (int i = tR - 1; i >= bL; i--) {
                    nums[count++] = matrix[bR - 1][i];
                }
                bR--;
            }
            if (bL < tR) {
                for (int i = bR - 1; i >= tL; i--) {
                    nums[count++] = matrix[i][bL];
                }
                bL++;
            }
        }
        return nums;
    }
}
