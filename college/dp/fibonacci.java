package dp;
import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(100));
    }
    public static long fib(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
    public static long helper(int n, long[] dp) {
        if (n <= 1) {
            return n;
        }
        if (dp[n] != -1) return dp[n];
        dp[n] = helper(n - 1, dp) + helper(n - 2, dp);
        return dp[n];
    }

    public static long fibonacci(int n) { 
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
    
}
