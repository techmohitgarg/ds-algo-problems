package com.mohit.array;

class MaxAreaOfIsland {
    public static void main(String[] args) {
        MaxAreaOfIsland areaOfIsland = new MaxAreaOfIsland();
        int[][] nums = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
        int result = areaOfIsland.maxAreaOfIsland(nums);
        System.out.println(result);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        boolean[][] seen = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, area(seen, grid, i, j));
            }
        }
        return max;
    }

    public int area(boolean[][] seen, int[][] nums, int i, int j) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length || seen[i][j] || nums[i][j] == 0) {
            return 0;
        }
        seen[i][j] = true;
        return (1 + area(seen, nums, i + 1, j) + area(seen, nums, i - 1, j) + area(seen, nums, i, j + 1)
                + area(seen, nums, i, j - 1));
    }
}