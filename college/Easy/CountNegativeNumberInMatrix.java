package Easy;

// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/  [SOLVED]

public class CountNegativeNumberInMatrix {
    public static void main(String[] args) {
        int[][] grid = {
            {4, 3, 2, -1},
            {3, 2, 1, -1},
            {1, 1, -1, -2},
            {-1, -1, -2, -3}
        };
        int[][] grid1 = {
            {3, 2},
            {1, 0},
        };
        System.out.println("Ans: " + countNegatives(grid1));
        

    }
    public static int countNegatives(int[][] grid) {
        int totalCount= 0;
        for (int[] nums: grid) {
            totalCount += countNegative(nums);
        }
        return totalCount;
        
    }
    public static int countNegative (int[] nums) {
        
        int s = 0;
        int e = nums.length - 1;

        while (s <= e) {
            int m = s + ( e - s) / 2;
            if (nums[m] < 0) e = m - 1;
            else if (nums[m] >= 0) s = m + 1;
        }
        return e == nums.length - 1 ? 0 : nums.length - s;
    }
}
