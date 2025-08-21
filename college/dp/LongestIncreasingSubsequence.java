package dp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        // System.out.println(lis(nums, 0, -1, new ArrayList<>()));
        System.out.println(longestIncSubseq(nums));
        System.out.println(longestSubseq(nums));
        
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

    // space optimization.
    public static int longestIncSubseq(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int num: dp) {
            max = Math.max(max, num);
        }
        return max;
    }

    // restoring subsequence.
    public static List<Integer> longestSubseq(int[] nums) {
        List<Integer> subseq = new ArrayList<>();

        int n = nums.length;
        int[] dp = new int[n];
        int[] p = new int[n];

        Arrays.fill(dp, 1);
        Arrays.fill(p, -1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    p[i] = j;
                }
            }
        }

        int max = 0;
        int maxIndx = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > max) {
                max = dp[i];
                maxIndx = i;
            }
        }
        
        while(maxIndx !=  -1) {
            subseq.add(nums[maxIndx]);
            maxIndx = p[maxIndx];
        }
        Collections.reverse(subseq);
        return subseq;
    }
}
