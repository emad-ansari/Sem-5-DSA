package subsequences;
import java.util.Arrays;

public class LongestIncreasingSubsequence {
    static int rec = 0, memo = 0;
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(withTabSpaceOptimize(nums));
        System.out.println(rec);
    }

    
    public static int longestIncreasingSequence(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n + 1];
        for (int[] arr: dp) Arrays.fill(arr, -1);

        return fn(nums, 0, -1);
        // return helper(nums, 0, -1, dp);
    }
    // Recursion
    private static int fn(int[] nums, int i, int prev) {
        rec++;
        if (i == nums.length) return 0;

        int pick = Integer.MIN_VALUE;
        if (prev == -1 || nums[i] > nums[prev]) {
            pick = 1 + fn(nums, i + 1, i);
        }
        int not_pick = fn(nums, i + 1, prev);
        return Math.max(pick, not_pick);
    }

    // memoization


    private static int helper(int[] nums, int i, int prev, int[][] dp) {
        if (i == nums.length) return 0;

        if (dp[i][prev + 1] != -1) return dp[i][prev + 1];
        int include = Integer.MIN_VALUE;
        if (prev == -1 || nums[i] > nums[prev]) {
            include = 1 + helper(nums, i + 1, i, dp);
        }
        int exclude = helper(nums, i + 1, prev, dp);
        return dp[i][prev + 1] = Math.max(include, exclude);
    }

    // With Tabulation
    private static int withTab(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    include=  1 + dp[i + 1][i + 1];
                }
                int exclude = dp[i + 1][prev + 1];
                dp[i][prev + 1]  = Math.max(include, exclude);
            }
        }
        return dp[0][0];
    }

    // With space optimization
    private static int withTabSpaceOptimize(int[] nums) {

        int n = nums.length;
        int[] next = new int[n + 1];
        int[] curr = new int[n + 1];
        
        for (int i = n - 1; i >= 0; i--) {
            for (int prev = i - 1; prev >= -1; prev--) {
                int include = 0;
                if (prev == -1 || nums[i] > nums[prev]) {
                    include=  1 + next[i + 1];
                }
                int exclude = next[prev + 1];
                curr[prev + 1]  = Math.max(include, exclude);
            }
            next = curr;
        }
        return next[0];
    }
    

}
