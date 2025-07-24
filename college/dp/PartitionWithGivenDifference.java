package dp;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/partitions-with-given-difference/1

public class PartitionWithGivenDifference {
    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 4};
        int d = 3;

        System.out.println(countPartitions(nums, d));
    }
    public static int countPartitions(int[] arr, int d) {
        // code here
        int sum = 0, n = arr.length;
        for (int num: arr) {
            sum += num;
        } 
        int ts = (sum - d) / 2;
        
        if ((sum - d) % 2 != 0 ||  sum < d) return 0;
        
        int[][] dp = new int[n][ts + 1];
        
        for (int[] nums: dp) {
            Arrays.fill(nums, -1);
        }
        
        return fxn(arr, 0, ts, dp);
        
    }
    
    public static int fxn(int[] nums, int i, int t, int[][] dp) {
        if (i == nums.length - 1) {
            if (t == 0 && nums[i] == 0) return 2;
            if (t == 0 || t == nums[i]) return 1; 
            return 0;
        }
        
        if (dp[i][t] != -1) return dp[i][t];
        
        int pick = 0;
        if (nums[i] <= t) {
            pick = fxn(nums, i + 1, t - nums[i], dp);
        }
        int nonPick = fxn(nums, i + 1, t, dp);
        
        return dp[i][t] = pick + nonPick;
    }


    public static int countPartitionsWithTabulation(int[] arr, int d) {
        // code here
        int sum = 0, n = arr.length;
        for (int num: arr) {
            sum += num;
        } 
        int ts = (sum - d) / 2;
        
        if ((sum - d) % 2 != 0 ||  sum < d) return 0;
        
        int[][] dp = new int[n + 1][ts + 1];
        
       for (int i = 0; i <= n; i++) {
            dp[i][0] = 1;
        }
        
        for (int i = n - 1; i >= 0; i--) {
            for (int t = 0; t <= ts; t++) {
                int take = 0;
                if (arr[i] <= t) {
                    take = dp[i + 1][t - arr[i]];
                }
                int nonTake = dp[i + 1][t];
                
                dp[i][t] = take + nonTake;
            }
        }
        
        
        return dp[0][ts];
    }
}
