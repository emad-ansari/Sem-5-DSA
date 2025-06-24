package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimizeCoins {

    public static void main(String[] args)throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");
            int n = Integer.parseInt(first[0]);
            int x = Integer.parseInt(first[1]);
            int[] coins = new int[n];
            for (int i = 0; i < n; i++) {
                coins[i] = Integer.parseInt(second[i]);
            }
            int[][] dp = new int[n][x + 1];
            System.out.println(withTab(coins, x, dp));
        } 
    }

    // Recursion
    public static int minimizeConWithRec(int[] coins, int indx, int ts) {
        if (indx == 0) {
            if (ts % coins[indx] == 0) return ts / coins[indx];
            else return (int)1e9;
        }
        int not_pick = 0 + minimizeConWithRec(coins, indx - 1, ts);
        int pick = Integer.MAX_VALUE;
        if (coins[indx] <= ts)  {
            pick = 1 + minimizeConWithRec(coins, indx, ts - coins[indx]);
        }

        return Math.min(pick, not_pick);
    }

    // Memoization
    public static int withMemoization(int[] coins, int indx, int ts, int[][] dp) {
        if (indx == 0) {
            if (ts % coins[indx] == 0) return ts / coins[indx];
            else return (int)1e9;
        }
        if (dp[indx][ts] != 0) return dp[indx][ts];

        int not_pick = 0 + withMemoization(coins, indx - 1, ts, dp);
        int pick = Integer.MAX_VALUE;
        if (coins[indx] <= ts) {
            pick = 1 + withMemoization(coins, indx, ts - coins[indx], dp);
        }
        return dp[indx][ts] = Math.min(pick, not_pick);
    }

    // Tabulation
    public static int withTab(int[] coins, int ts, int[][] dp) {
        int n = coins.length;
        for (int i = 0; i <= ts; i++) {
            if (i % coins[0] == 0) dp[0][i] = i / coins[0];
            else dp[0][i] = (int)1e9;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= ts; j++) {
                int not_pick = dp[i - 1][j];    
                int pick = Integer.MAX_VALUE;
                if (coins[i] <= j) {
                    pick = 1 + dp[i][j- coins[i]];
                }
                dp[i][j] = Math.min(pick, not_pick);
            }
        }
        return dp[n - 1][ts];
    }

    // try to understand the below method

    private static int minizeCoin(int x, int[] nums, int[] dp) {
        if (x == 0) return 0;

        if (dp[x] != 0) return dp[x];
        int val = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(x - nums[i] < 0) continue;
            val = Math.min(val, minizeCoin(x - nums[i], nums, dp) + 1);
        }
        return dp[x] = val;
    }

}
