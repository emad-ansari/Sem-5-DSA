package dp;
import java.util.Arrays;

public class DistinctSubsequences {
    public static void main(String[] args) {
        System.out.println(numDistinct("babgbag", "bag"));
    }

    public static int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp =  new int[m][n];
        for (int[] nums: dp) Arrays.fill(nums, -1);
        return fxn(s, t, m - 1, n - 1, dp);
    }

    public static int fxn (String s, String t, int i, int j, int[][] dp) {
        if (j < 0) return 1;
        if (i < 0) return 0;

        if (dp[i][j] != -1) return dp[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            dp[i][j] = fxn(s, t, i - 1, j - 1, dp) + fxn(s, t, i - 1, j, dp);
        }
        else dp[i][j] = fxn(s, t, i - 1, j, dp);
        return dp[i][j];
    }

    public static int tab(String s, String t) {
        int m = s.length(), n = t.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
                else dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[m][n];
    }

}