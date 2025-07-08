package dp;

public class PerfectSum {
    public static void main(String[] args) {
        
    }
    public int perfectSum(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][target + 1];
        return fxn(nums, 0, target, dp);
    }
    
    public int fxn(int[] nums, int i, int sum, int[][] dp ) {

        if (sum == 0) return 1;
        if (i == nums.length) return 0;

        if (dp[i][sum] != -1) return dp[i][sum];

        int skip = fxn(nums, i + 1, sum, dp);


        if (nums[i] <= sum) {
            dp[i][sum] = skip +  fxn(nums, i + 1, sum - nums[i], dp);
        }
        return dp[i][sum];

    }

    // with tabulation
    public int perfectSumWithTab(int[] nums, int target) {
        // code here
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        
        for (int i = 0; i <= n; i++) dp[i][0] = 1;
        
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= target; j++) {
                int take = 0;
                if (nums[i] <= j) {
                    take = dp[i + 1][j - nums[i]];
                }
                int skip = dp[i + 1][j];
                
                dp[i][j] = take + skip;
            }
        }
        
        return dp[0][target];
    }
}
