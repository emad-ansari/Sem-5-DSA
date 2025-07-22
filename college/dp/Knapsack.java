package dp;

public class Knapsack {
    public static void main(String[] args) {
        int[] p = {10, 40, 30, 50};
        int[] wt = {5, 4, 2, 3};
        System.out.println(fn(p, wt, 5));
    }
    static int knapsack(int W, int val[], int wt[]) {
        // code here
        int n = val.length;
        int[][] dp = new int[n + 1][W + 1];
        for (int[] arr: dp) {
            for (int i = 0; i < arr.length; i++) arr[i] = -1;
        }
        return fxn(val, wt, val.length, W, dp);   
        
    }
    // Memoization
    public static int fxn(int[] val, int[] wt, int i, int c, int[][] dp) {
        if (i == 0 || c <= 0) return 0;
        
        if (dp[i - 1][c] != -1) return dp[i - 1][c];
        int pick = Integer.MIN_VALUE;
        if (c >= wt[i - 1]) {
            pick = val[i - 1] + fxn(val, wt, i - 1, c - wt[i - 1], dp);
        }
        int nonPick = fxn(val, wt, i - 1, c, dp);
        return dp[i - 1][c] = Math.max(pick, nonPick);
    }
 
    // Tabulation
    public static int fn(int[] val , int[] wt, int c) {
        int n = val.length;
        int[][] dp = new int[n + 1][c + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= c; j++) {
                int pick = 0;
                if (j >= wt[i - 1]) {
                    pick = val[i - 1] + dp[i - 1][j - wt[i -1]];
                }
                int nonPick = dp[i - 1][j];
                dp[i][j] = Math.max(pick, nonPick);
            }
        }
        return dp[n][c];
    }

    
}
