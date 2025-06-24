package dp;

import java.util.Arrays;

public class TargetSum {
    static int cnt = 0, count = 0;

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int t = 3;
        int[][] dp = new int[20][40001];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        // System.out.println(fts(nums, 0, t, dp));
        // System.out.println(count);
        System.out.println(fn(nums, 0, t));
        System.out.println(cnt);

    }
    // Recursion
    public static int fn(int[] nums, int i, int t) {
        cnt++;
        if (i == nums.length && t == 0) return 1;
        if (i == nums.length && t != 0) return 0;
        
        int pick = fn(nums, i + 1, t - nums[i]);
        int nonPick = fn(nums, i + 1, t + nums[i]);
        return pick + nonPick;
    }

    // Memoization
    public static int fts(int[] nums, int i, int t, int[][] dp) {
        count++;
        if (i == nums.length && t == 0) return 1;
        if (i == nums.length && t != 0) return 0;

        if (dp[i][t + 1000] != -1 ) return dp[i][t + 1000];
        int take = fts(nums, i + 1, t - nums[i], dp);
        int non_take = fts(nums, i + 1, t + nums[i], dp);

        return dp[i][t + 1000] = take + non_take;

    }

    
}
