package dp;

// https://leetcode.com/problems/house-robber/ [SOLVED]
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5}; // Example input values
        System.out.println(maxRob(nums));
        
    }
    public static int rob(int[] nums) {

        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n];
        dp[0] = nums[0];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[n - 1];
    }
    public static int maxRob(int[] nums) {
        int n = nums.length, prev = nums[0], curr = Math.max(nums[0], nums[1]), next = 0;
        for (int i = 2; i < n; i++) {   
            next = Math.max(curr, prev + nums[i]);
            prev = curr;
            curr = next;
        }
        return next;

    }
    
}
