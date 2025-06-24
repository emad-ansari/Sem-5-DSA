package dp;
import java.util.Scanner;
import java.util.Arrays;
public class JobsAndWorker {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of workers: ");
        int n = in.nextInt();
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cost[i][j] = in.nextInt();
            }
        }

        int[][] dp = new int[n][1 << n];
        for (int[] nums: dp) Arrays.fill(nums, -1);

        System.out.println(minCost(0, (1 << n) - 1 , n,  dp, cost));
        in.close();


    }
    public static int minCost(int i, int mask, int n , int[][] dp, int[][] cost) {
        if (i == n) return 0;
        if (dp[i][mask] != -1 ) return dp[i][mask];

        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            if ((mask & (1 << j)) != 0 ) {
                res = Math.min(res, cost[j][i] + minCost(i + 1, mask ^ (1 << j) ,n , dp, cost));
            }
        }
        return dp[i][mask] = res;
    }
    
}
