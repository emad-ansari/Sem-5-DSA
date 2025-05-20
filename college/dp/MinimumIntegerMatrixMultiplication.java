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
        return fxn(1, n - 1, arr, dp);
    }
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
}
