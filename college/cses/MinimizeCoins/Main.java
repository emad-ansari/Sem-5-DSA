package cses.MinimizeCoins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
         try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");
            int n = Integer.parseInt(first[0]);
            int x = Integer.parseInt(first[1]);
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(second[i]);
            }
            int[] dp = new int[x + 1];
            System.out.println(minizeCoin(x, nums, dp));
        }

    }
    public static int minizeCoin(int x, int[] nums, int[] dp) {
        
        for (int i = 1; i <= x; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < nums.length; j++) {
                if(i >= nums[j] && dp[i - nums[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - nums[j]] + 1);
                } ; 
            }
        }
        return dp[x] == Integer.MAX_VALUE ? -1 : dp[x];
    }
    
    
}
