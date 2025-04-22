package dp;
import java.util.Arrays;
public class BuyAndSellstock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));

    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        for (int i = 0; i < n - 1; i++) {
            prices[i] = prices[i + 1] - prices[i];
        }
        prices[n - 1] = 0;
        int[] dp  = new int[n];
        Arrays.fill(dp, -1);
        return helper(prices, 0, dp);
    }
    private static int helper(int[] nums, int i, int[] dp) {
        if (i >= nums.length) return 0;

        if (dp[i] != -1) return dp[i];
        return dp[i] = Math.max(nums[i] + helper(nums, i + 1, dp), 0 + helper(nums, i + 1, dp));
    }

    // Using Sliding Window
    public static int maxProfit1(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;
        int l = 0, r = 1, diff = 0, maxp = Integer.MIN_VALUE;
        while (r < n) {
            while (l < n && prices[r]- prices[l] < 0) {
                diff = prices[r] - prices[l];
                maxp = Math.max(maxp, diff);
                l++;
            }
            if (l == n) break;
            maxp = Math.max(maxp, prices[r] - prices[l]);
            r++;
        }
        return maxp == Integer.MIN_VALUE ? 0 : maxp;
    }
    
}
