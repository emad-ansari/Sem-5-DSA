package dp;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins, 11));
    }
    public static int coinChange(int[] coins, int amount) {
        int n = coins.length;
        
        int[][] dp = new int[n + 1][amount + 1];
        for (int[] nums : dp) Arrays.fill(nums, -1);
        int ans = fxn(coins, n, amount, dp);
        return ans >= (int)1e9 ? -1 : ans;
    }
    public static int fxn(int[] coins, int i, int ts, int[][] dp) {
        // base condition
        if (ts == 0) return 0;
        if (i == 0) return (int)1e9;
       

        if (dp[i][ts] != -1) return dp[i][ts];

        // pick
        int pick = Integer.MAX_VALUE;

        if (coins[i - 1] <= ts) {
            pick = 1 + fxn(coins, i, ts - coins[i - 1], dp);
        }
        int not_pick = fxn(coins, i - 1,  ts, dp);
        return dp[i][ts] = Math.min(pick, not_pick);
    }
    
}
