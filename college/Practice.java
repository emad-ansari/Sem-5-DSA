import java.util.Arrays;
import java.util.Comparator;
public class Practice {
    // Longest common subsequence

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "def";
        // System.out.println(longestCommonSubsequence(s1, s2));
        System.out.println(lcsTab(s1, s2));
    }

    // Longest common subsequence
    public static int longestCommonSubsequence(String s1, String s2) {
        // recrusion way
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int[] nums: dp) Arrays.fill(nums, -1);

        return lcsMemo(s1, s2, 0, 0, dp);
    }
    // Recursion
    public static int lcs(String s1, String s2, int i, int j) {
        if (i == s1.length() || j == s2.length()) return 0;

        if (s1.charAt(i) == s2.charAt(j)) return  1 + lcs(s1, s2, i + 1, j + 1);
        else return Math.max(lcs(s1, s2, i + 1, j), lcs(s1, s2, i, j + 1));
    }

    // Memoization 
    public static int lcsMemo(String s1, String s2, int i, int j, int[][] dp) {
        if (i == s1.length() || j == s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];
        if (s1.charAt(i) == s2.charAt(j)) {
            return dp[i][j] = 1 + lcsMemo(s1, s2, i + 1, j + 1, dp);
        }
        else return dp[i][j] = Math.max(lcsMemo(s1, s2, i + 1, j, dp), lcsMemo(s1, s2, i, j + 1, dp));
    }
    public static int lcsTab(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1 ; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                }
                else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
        return dp[0][0];
    }

}