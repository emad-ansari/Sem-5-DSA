package dp;

import java.util.Arrays;
//https://www.geeksforgeeks.org/problems/palindromic-patitioning4845/1
public class PalindromicPartitioning {
  
    public static int palPartition(String s) {
        // code here
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] nums: dp) Arrays.fill(nums, -1);
        return fxn(s, 0, n - 1, dp);
        
        
    }
    public static int fxn (String s, int i, int j, int[][] dp) {
        if (i == j) return 0;
        if (isPalindrome(s, i, j)) return 0;
        
        if (dp[i][j] != -1) return dp[i][j];
        int res = (int)1e9;
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                res = Math.min(res, 1 + fxn(s, i, k, dp) + fxn(s, k + 1, j, dp)); 
            }
        }
        
        return dp[i][j] = res;
    }
    
    public static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
