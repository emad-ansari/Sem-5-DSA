package dp;
import java.util.Arrays;
public class PartitionEqualSubsetSum {
    static int cnt = 0;
    static int count = 0;
    public static void main(String[] args) {
        int[] nums = {23,13,11,7,6,5,5};
        System.out.println(canPartition(nums));
        // System.out.println(cnt);
        System.out.println(count);

        
    }
    public static boolean canPartition(int[] nums) {
        int ts = 0, n = nums.length;
        for (int num: nums) ts += num;
        int[][] dp = new int[n][ts +1];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        
        // return fn(nums, 0, 0, ts / 2);
        
        return fxn(nums, 0, 0, ts / 2, dp) == 1 ? true : false;
        
    }
    // recursion
    public static boolean fn (int[] nums, int i, int sum, int ts) {
        cnt++;
        if (i == nums.length && sum == ts) return true;
        if ((i == nums.length && sum != ts) || sum > ts) return false;

        return fn(nums, i + 1, sum + nums[i], ts) || fn(nums, i + 1, sum, ts);
    }

    //memoization

    public static int fxn(int[] nums, int i, int s, int ts, int[][] dp) {
        count++;
        if ((i == nums.length && s != ts) || s > ts) return 0;
        if (i == nums.length && s == ts) return 1;
        

        if (dp[i][s] != -1) return dp[i][s];
        int pick = fxn(nums, i + 1, s + nums[i], ts, dp);
        int non_pick =  fxn(nums, i + 1, s, ts, dp);
        return dp[i][s] = Math.max(pick, non_pick);
    }
}