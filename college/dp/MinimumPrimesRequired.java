package dp;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPrimesRequired {
    static int rec = 0;
    static int memo = 0;
    public static void main(String[] args) {
        // N --> 10^3 & M --> 10^4
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the value of  N : ");
        int N = input.nextInt();
        System.out.println();
        System.out.print("Enter the value of M: ");
        int M = input.nextInt();
        System.out.println();
        int[] primes = calPrimes(M);
       
        int[][] dp = new int[M][N + 1];
        for (int[] nums : dp) Arrays.fill(nums, -1);

        System.out.println(minPrimesRequired(primes, N, M, dp));
        // System.out.println(rec);
        System.out.println(memo);
        input.close();
    }

    public static int minPrimesRequired(int[] primes, int N, int M, int[][] dp) {
        int n = primes.length;
        // return helper(primes, n - 1, N);
        return withMemoization(primes, n - 1 , N, dp);
    }

    public static int helper(int[] primes, int i, int ts) {
        // base condition
        rec++;
        if (i == 0) {
            if (ts % primes[i] == 0) return ts / primes[i];
            else return (int)1e9;
        }
        // pick
        int pick = Integer.MAX_VALUE;
        if (primes[i] <= ts) {
            pick = 1 + helper(primes, i, ts - primes[i]);
        }
        int not_pick = helper(primes, i - 1, ts);
        
        return Math.min(pick, not_pick);
    }

    public static int[] calPrimes(int M) {
        // how can I generate first M primes numbers
        int[] primes = new int[M];
        int count = 0, i = 2, k = 0;
        while (count != M) {
            if (isPrime(i)) {
                primes[k++] = i;
                count++;
            }
            i++;
        }
        return primes;
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // MEMOIZATION
    public static int withMemoization(int[] primes, int i, int ts, int[][] dp) {
        // base condition
        memo++;
        if (i == 0) {
            if (ts % primes[i] == 0) return ts / primes[i];
            else return (int)1e9;
        }

        if (dp[i][ts] != -1) return dp[i][ts];

        // pick
        int pick = Integer.MAX_VALUE;

        if (primes[i] <= ts) {
            pick = 1 + withMemoization(primes, i, ts - primes[i], dp);
        }
        int not_pick = withMemoization(primes, i - 1,  ts, dp);
        
        return dp[i][ts] = Math.min(pick, not_pick);
    }

    /*
     * Tabulation: 
     *  Time complexity: O(n * t)
     *  Space complexity: O(n * t)
     */
    public static int withTab(int[] primes, int ts, int[][] dp) {
        int n = primes.length;
        for (int t = 0; t <= ts; t++) {
            if (t % primes[0] == 0) dp[0][t] = t / primes[0];
            else dp[0][t] = (int)1e9;
        }
        for (int i = 1; i < n; i++) {
            for (int t = 0; t <= ts; t++) {
                int pick = Integer.MAX_VALUE;
                if (primes[i] <= t) pick = 1 + dp[i][t - primes[i]];
                int not_pick = dp[i - 1][t];
                dp[i][t] = Math.min(pick, not_pick);
            }
        }
        return dp[n - 1][ts];
    }


}
