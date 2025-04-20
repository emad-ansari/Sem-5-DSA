package dp;
import java.util.Arrays;
public class ClimbingStairs {
    static int cnt = 0;
    static int count = 0;
    public static void main(String[] args) {

        int n = 5;
        int[] dp = new int[n + 1];
        System.out.println(climbTab(n, dp));
        Arrays.fill(dp, -1);
        System.out.println(climb(n, 0));
        System.out.println(cnt);
        System.out.println(climbDp(n, 0, dp));
        System.out.println(count);
    }
    // recursion
    public static int climb(int n, int s) {
        cnt++; // no of fun calls in recursion
        if (s == n) return 1;
        if (s > n) return 0;

        return climb(n, s + 1) + climb(n, s + 2);
    }
    // dp
    public static int climbDp(int n, int s, int[] dp) {
        count++; // no fo fun calls memoization
        if (s == n) return 1;
        if (s > n) return 0;
        if (dp[s] != -1) return dp[s];
        return dp[s] = climbDp(n, s + 1, dp) + climbDp(n, s + 2, dp);
    }
    
    // Tabulation
    public static int climbTab(int n, int[] dp) {
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // space optimization
    public static int climb2(int n) {
        if (n <= 1) return 1;
        int curr = 1, prev = 1, next = 0;
        for (int i = 2; i <= n; i++) {
            next = curr + prev;
            prev = curr;
            curr = next;
        }
       return  next;
    }
    
}
