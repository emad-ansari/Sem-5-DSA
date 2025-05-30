package dp;

public class CoinChage2 {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        
        int[][] dp = new int[n + 1][amount + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n ; i++) {
            for (int j = 0; j <= amount; j++) {
                int pick = 0;
                if (coins[i - 1] <= j) {
                    pick =  dp[i][j - coins[i - 1]];
                }
                int not_pick = dp[i - 1][j];
                dp[i][j] = pick  + not_pick;
            }
        }
        return  dp[n][amount];
    }
    
}
