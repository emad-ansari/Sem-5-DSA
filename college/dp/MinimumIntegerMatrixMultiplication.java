package dp;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/matrix-chain-multiplication0303/1  [SOLVED]
public class MinimumIntegerMatrixMultiplication {
    public static void main(String[] args) {
        int[] arr = {2, 1, 3, 4};
        System.out.println(matrixMultiplication(arr));
        
    }
    public static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        int[][] dp = new int[n][n];
        for (int[] nums: dp) Arrays.fill(nums, -1);
        return memo(arr, 1, n - 1, dp);
    }
    // memo
    public static int fxn(int i, int j, int[] arr, int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for (int p = i; p < j; p++) {
            int res = fxn(i, p, arr, dp) + fxn(p + 1, j, arr, dp) + arr[i - 1] * arr[p] * arr[j];
            min = Math.min(min, res);
        }
        return dp[i][j] = min;
    }

    // Recursion
    public static int rec(int[] arr, int i, int j) {
        if (i == j) return 0;
        int min = (int)1e9;
        for (int k = i; k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + rec(arr, i, k) + rec(arr, k + 1, j);
            min = Math.min(min, steps);
        }
        return min;
    }

    // memoization
    public static int memo (int[] arr, int i, int j , int[][] dp) {
        if (i == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int min = (int)1e9;
        for (int k = i; k < j; k++) {
            int steps = (arr[i - 1] * arr[k] * arr[j]) + memo(arr, i, k, dp) + memo(arr, k + 1, j, dp);
            min = Math.min(min, steps);
        }
        return dp[i][j] = min;
    }
    // Tabulation
    public static int tab(int[] arr, int[][] dp) {
        int n = arr.length;
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j < n; j++) {
                int min = (int)1e9;
                for (int k = i; k < j; k++) {
                    int cost = (arr[i - 1] * arr[k] * arr[j]) + dp[i][k] + dp[k + 1][j];
                    min = Math.min(min, cost);
                }
                dp[i][j] = min;
            }
        }
        return dp[1][n - 1];
    }
    
}
