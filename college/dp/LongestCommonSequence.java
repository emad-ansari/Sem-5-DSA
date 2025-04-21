package dp;
import java.util.Arrays;


public class LongestCommonSequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));
        
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] arr: dp) Arrays.fill(arr, -1);
        return lcs(text1, text2, m - 1, n - 1, dp);

    }
    public static int lcs(String s1, String s2, int i, int j, int[][] dp) {
        if (i == -1 || j == -1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) return dp[i][j] = 1 + lcs(s1, s2, i - 1, j - 1, dp);
        else return dp[i][j] = Math.max(lcs(s1, s2, i - 1, j, dp), lcs(s1, s2, i, j -1, dp));
    }

    //Tabulation
    public static int lcsTab(String s1, String s2, int[][] dp) {
        int m = s1.length(), n = s2.length();
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return dp[m][n];
    }


}
