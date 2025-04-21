package dp;

import java.util.Arrays;

public class MinCostClimbingStairs {

    public static void main(String[] args) {
        int[] costs  = {10, 15, 20};
        System.out.println(minCostClimbingStairs(costs));
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min( climb(n, 0, dp, cost),  climb(n, 1, dp, cost));
    }
    public static int climb(int n, int i, int[] dp, int[] cost) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        int jump1 = cost[i] + climb(n, i + 1, dp, cost);
        int jump2 = cost[i] + climb(n, i + 2, dp, cost);
        return dp[i] = Math.min(jump1, jump2);
    }
    // Tabulation 
    public int minCostClimbingStairsTab(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            int jump1 = cost[i - 1] + dp[i - 1];
            int jump2 = cost[i -2] + dp[i - 2];    
            dp[i] = Math.min(jump1, jump2);
        }
        return dp[n];
    }
   
}
