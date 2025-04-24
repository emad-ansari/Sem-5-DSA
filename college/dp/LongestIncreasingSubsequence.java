package dp;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
        
    }
    public static int lengthOfLIS(int[] nums) {
        // return fxn(nums, 0, -1);
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        return fn(nums, 0, -1, dp);

    }
    public int fxn(int[] nums, int i, int prev) {
        if (i == nums.length) return 0;
        int inc = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            inc = 1 + fxn(nums, i + 1, i);
        }
        return Math.max(inc, fxn(nums, i + 1, prev));

    }

    // memoization
    public static int fn(int[] nums, int i , int prev, int[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        int inc  = 0;
        if (prev == -1 || nums[prev] < nums[i]) {
            inc = 1 + fn(nums, i + 1, i, dp);
        }
        return dp[i][prev + 1] = Math.max(inc, fn(nums, i + 1, prev, dp));

    }

    //tabulation
    public static int fnt(int[] nums) {
        int n = nums.length, prev = -1;
        int[][] dp = new int[n][n + 1];
        dp[0][0] = 1;
        for (int i = 1; i < n - 1; i++) {
            int inc = 0;
            if (prev == -1 || nums[prev] < nums[i]) {
                inc = 1 + dp[i + 1][i];
            }
            int ex = dp[i + 1][prev];
            dp[i][prev + 1] = Math.max(inc, ex);

        }
        return dp[n - 1][n];
    }
    
}
