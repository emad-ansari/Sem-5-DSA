package dp;

import java.util.Arrays;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int t = 3;
        int[][] dp = new int[20][40001];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        System.out.println(fts(nums, 0, t, dp));
    }
    // Recursion
    public static int fn(int[] nums, int i, int t) {
        if (i == nums.length && t == 0) return 1;
        if (i == nums.length && t != 0) return 0;
        
        int pick = fn(nums, i + 1, t - nums[i]);
        int nonPick = fn(nums, i + 1, t + nums[i]);
        return pick + nonPick;
    }

    // Memoization
    public static int fts(int[] nums, int i, int t, int[][] dp) {
        if (i == nums.length && t == 0) return 1;
        if (i == nums.length && t != 0) return 0;

        if (dp[i][t + 1000] != -1 ) return dp[i][t + 1000];
        int take = fts(nums, i + 1, t - nums[i], dp);
        int non_take = fts(nums, i + 1, t + nums[i], dp);

        return dp[i][t + 1000] = take + non_take;

    }

    // Tabulation

    // public static int ftsT(int[] nums, int t) {
    //     int[][] dp = new int[20][40001];


    // }
    
}
