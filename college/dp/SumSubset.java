package dp;

// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1 [SOLVED]

public class SumSubset{
    public static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (Boolean[] num: dp) {
            for (int j = 0; j < num.length; j++) num[j] = null;
        }
        return fxn(arr, 0, sum, dp);
    }
    // Memoization
    public static Boolean fxn(int[] arr, int i, int t, Boolean[][] dp) {
        if (t == 0) return true;
        if (i == arr.length) return false;
        if (dp[i][t] != null) return dp[i][t];
        boolean pick = false;
        if (t >= arr[i]) {
            pick = fxn(arr, i + 1, t - arr[i], dp);
        }
        if (pick) return true;
        
        boolean nonPick = fxn(arr, i + 1, t, dp);
        return dp[i][t] = (pick || nonPick);
    }

    // Tabulation
    public static boolean subsetSumWithTab(int[] nums, int target){
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];

        for (int row = 0; row < n; row++) {
            dp[row][0] = 1;
        }

        for (int row = n - 1; row >= 0; row--) {
            for (int t = target; t >= 0; t--) {
                int pick = 0;
                if (nums[row] <= t) {
                    pick = dp[row + 1][t - nums[row]];
                }
                int not_pick = dp[row + 1][t];

                dp[row][t] = pick | not_pick;
            }
        }

        return dp[0][target] == 1;
    }

}