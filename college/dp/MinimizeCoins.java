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
            int[] nums = new int[n];
            for (int i = 0; i < nums.length; i++) {
                nums[i] = Integer.parseInt(second[i]);
            }
            int[] dp = new int[x + 1];
            System.out.println(minizeCoin(x, nums, dp));

        }
       
        
    }
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
