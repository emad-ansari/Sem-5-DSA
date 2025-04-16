package dp;


import java.util.Scanner;

public class DiceCombination {
    static int M = 1000000007;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long ans = dice(n, dp);
        System.out.print(ans % M);
        input.close();
    }
    public static long dice(int n, long[] dp) {
        if (n <= 1) return 1;
        if (dp[n] != 0) return dp[n];
        for (int i = 1; i <= 6; i++)  {
            if (n - i < 0) break;
            dp[n] = (dp[n] +  dice(n - i, dp)) % M;
        }
        return dp[n];
    }
    
}
