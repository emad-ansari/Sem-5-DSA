package dp;

// https://leetcode.com/problems/house-robber-ii/ [SOLVED]
public class HouseRobber2 {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];
        return Math.max(maxRob(nums, 0), maxRob(nums, 1));
    }
    public int maxRob(int[] nums,int s) {
        int n = nums.length, e = s == 0 ? n - 1 : n;
        int[] dp = new int[n];
        if (s == 1) dp[0] = 0;
        else dp[0] = nums[0];

        dp[1] = Math.max(dp[0], nums[1]);
        for (int i = 2; i < e; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[e - 1];
    }
}
