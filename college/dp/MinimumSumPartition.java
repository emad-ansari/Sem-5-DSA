package dp;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/minimum-sum-partition3317/1 [solved]
public class MinimumSumPartition {
    static int ts;
    public static void main(String[] args) {
        int[] nums = {1, 6, 11, 5};
        System.out.println(minDifference(nums));

    }
    public static int minDifference(int arr[]) {
        // Your code goes here
        int n = arr.length;
        for (int num: arr) ts += num;
        int[][] dp = new int[n][ts + 1];
        for (int[] nums: dp) Arrays.fill(nums, -1);
        return helper(arr, 0, ts, dp);
    }
    
    private static int helper(int[] nums, int indx, int sum, int[][] dp) {
        if (indx == nums.length) {
            return Math.abs(ts - 2 * sum);
        }
        
        if (dp[indx][sum] != -1) return dp[indx][sum];
        int pick = helper(nums, indx + 1, sum - nums[indx], dp);
        int not_pick = helper(nums, indx + 1, sum, dp);
        return dp[indx][sum] = Math.min(pick, not_pick);
    }
    
}
