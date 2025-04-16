package dp;

import java.util.Arrays;

public class NumberOfWaystoReduceZero {
    public static void main(String[] args) {
        System.out.println(numberOfWaysToRecdueZero1(10));
    }
    public static int fn(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return numberOfWaysToRecdueZero(n, dp);

    } 
    public static int numberOfWaysToRecdueZero(int n, int[] dp) {
        if (n == 0) return 1;

        if (dp[n] != -1) return dp[n];
        dp[n] = numberOfWaysToRecdueZero(n / 2, dp) + numberOfWaysToRecdueZero(n / 3, dp);
        return dp[n];
    } 
    public static int numberOfWaysToRecdueZero1(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i / 2] + dp[i / 3];
        }
        return dp[n];
    } 
}
