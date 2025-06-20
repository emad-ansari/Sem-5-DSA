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
        if (ts % 2 != 0) return false;

        int[][] dp = new int[n][ts / 2 + 1];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        
        // return fn(nums, 0, ts / 2);
        
        return fxn(nums, 0, ts / 2, dp) == 1;
        
    }
    // recursion
    public static boolean fn(int[] nums, int i, int ts) {
        cnt++;
        if (i == nums.length && ts == 0) return true;
        if (i == nums.length && ts != 0) return false;

        return fn(nums, i + 1, ts - nums[i]) || fn(nums, i + 1, ts);
    }

    //memoization
    public static int fxn(int[] nums, int i, int ts, int[][] dp) {
        if (ts == 0) return 1;
        if (i == nums.length || ts < 0) return 0;;

        if (dp[i][ts] != -1) return dp[i][ts];
        
        int pick = fxn(nums, i + 1, ts - nums[i], dp);
        if (pick == 1) return dp[i][ts] = 1; // for efficient returning when ans found

        int not_pick = fxn(nums, i + 1, ts, dp);
        return dp[i][ts] = not_pick;
    }
}