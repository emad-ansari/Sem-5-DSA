package cses;
import java.util.Scanner;

public class Main {
    static  int M = 1000000007;
     public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long[] dp = new long[n + 1];
        dp[0] = 1;
        long ans = diceTab(n, dp);
        System.out.print(ans % M);
        input.close();
    }
    public static long diceTab(int n, long[] dp) {

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 6; j++)  {
                if (i - j < 0) break;
                dp[i] = (dp[i] +  dp[i - j]) % M;
            }
        }
        return dp[n];
    }
}
