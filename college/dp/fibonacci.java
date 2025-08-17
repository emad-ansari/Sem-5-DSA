package dp;
import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fibo(10)); // 0 1 1 2 3 5 
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

    // Space optimized solution
    public static long fibo(int n) {
        if (n <= 1) return n;
        long ans = 0;
        long  a = 0, b = 1;

        for (int i = 2; i <= n; i++) {
            ans = a + b;
            a = b;
            b = ans;
        }

        return ans;
    }
    
}
