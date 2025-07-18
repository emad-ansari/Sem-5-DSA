package dp;

import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/triangle/  [SOLVED]
public class Triangle {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        for (int[] nums: dp) Arrays.fill(nums, Integer.MAX_VALUE);
        return helper(triangle, 0, 0, dp);
        

    }
    public static int helper(List<List<Integer>> tri, int i, int j, int[][] dp) {
        if (j < 0 || i >= tri.size() || j == tri.get(i).size()) return (int)2e6 + 1;

        if (i == tri.size() - 1) return tri.get(i).get(j);
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];

        return dp[i][j] = tri.get(i).get(j) + Math.min(helper(tri, i + 1, j, dp), helper(tri, i + 1, j + 1, dp));

    }
}
