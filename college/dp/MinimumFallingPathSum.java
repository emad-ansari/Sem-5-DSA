package dp;

import java.util.Arrays;

// https://leetcode.com/problems/minimum-falling-path-sum/description/  [SOLVED]
public class MinimumFallingPathSum {
    public static void main(String[] args) {
        int[][] mat = {{2, 1, 3}, {6, 5, 4}, {7, 8, 9}};
        System.out.println(minFallingPathSum(mat));
        
    }
    public  static int minFallingPathSum(int[][] mat) {
        int min = Integer.MAX_VALUE, n = mat.length;
        int[][] dp = new int[n][n];
        for (int[] nums: dp) Arrays.fill(nums, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            min = Math.min(min, fn(mat, 0, i, dp));
        }
        return min;
    }
    public static int fn(int[][] mat, int i , int j, int[][] dp) {
        // base conditon
        if (j < 0 || j > mat.length-1) return (int)(1e4 + 1);
        if (i == mat.length - 1) return mat[i][j];
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int first =  fn(mat, i + 1, j, dp);
        int second =  fn(mat, i + 1, j + 1, dp);
        int th =   fn(mat, i +1, j - 1, dp);
        return dp[i][j] =  Math.min(first, Math.min(second, th)) + mat[i][j];
    }
    
}
