package dp;

import java.util.Arrays;

//https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1
public class PalindromicPartitioning {
    public static void main(String[] args) {
        String s = "ababbbabbababa";
        System.out.println(palPartition(s));
    }

    public static int palPartition(String s) {
        // code here
        int n = s.length();
        int[][] dp = new int[n][n];
        // for (int[] nums: dp) Arrays.fill(nums, -1);
        // return fxn(s, 0, n - 1, dp);
        return palPartioningWithTab(s, dp);

    }

    // recursion
    public static int fn(String s, int i, int j) {
        if (i == j)
            return 0;
        if (isPalindrome(s, i, j))
            return 0;
        int min = (int) 1e9;
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                int p = fn(s, i, k) + fn(s, k + 1, j);
                min = Math.min(min, 1 + p);
            }
        }
        return min;
    }

    // memoization
    public static int fxn(String s, int i, int j, int[][] dp) {
        if (i == j)
            return 0;
        if (isPalindrome(s, i, j))
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        int res = (int) 1e9;
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                res = Math.min(res, 1 + fxn(s, i, k, dp) + fxn(s, k + 1, j, dp));
            }
        }

        return dp[i][j] = res;
    }

    public static int palPartioningWithTab(String s, int[][] dp) {
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = (int) 1e9;
                if (isPalindrome(s, i, j)) {
                    dp[i][j] = 0;
                    continue;
                }
                for (int k = i; k < j; k++) {
                    int p = dp[i][k] + dp[k + 1][j] + 1;
                    min = Math.min(min, p);
                }
                dp[i][j] = min;
            }
        }
        return dp[0][n - 1];
    }

    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r))
                return false;
            l++;
            r--;
        }
        return true;
    }
}
