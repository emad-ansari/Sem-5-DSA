package dp;

// https://www.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1 [SOLVED]

public class SumSubset{

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n = arr.length;
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        for (Boolean[] num: dp) {
            for (int j = 0; j < num.length; j++) num[j] = null;
        }
    return fxn(arr, 0, sum, dp);
    }
    public static Boolean fxn(int[] arr, int i, int t, Boolean[][] dp) {
        if (t == 0) return true;
        if (i == arr.length) return false;
        if (dp[i][t] != null) return dp[i][t];
        boolean pick = false;
        if (t >= arr[i]) {
            pick = fxn(arr, i + 1, t - arr[i], dp);
        }
        boolean nonPick = fxn(arr, i + 1, t, dp);
        return dp[i][t] = (pick || nonPick);
    }
}