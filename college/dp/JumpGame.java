package dp;

// https://leetcode.com/problems/jump-game/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 1;
       
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 1; j <= nums[i]; j++) {
                if (i + j < n && dp[i + j] == 1) {
                    dp[i] = 1;
                    break;
                }
            }
        }

        return dp[0] == 1;
    } 
}
