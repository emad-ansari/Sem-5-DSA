package dp;

// https://leetcode.com/problems/palindromic-substrings/ 
public class CountAllPalindromeSubstring {
    public static void main(String[] args) {

    }

    public int countSubstrings(String s) {
        int n = s.length();
        boolean[][] dp_palindrome = new boolean[n][n];
        preComputePalindromeSubstrings(s, dp_palindrome);
        int countPal = 0;
        for (boolean[] arr : dp_palindrome) {
            for (boolean item : arr) {
                if (item)
                    countPal++;
            }
        }
        return countPal;
    }

    public static void preComputePalindromeSubstrings(String s, boolean[][] dp_palindrome) {
        // all string with one character is palindrome
        int n = s.length();
        for (int i = 0; i < n; i++) {
            dp_palindrome[i][i] = true;
        }

        // all palindrome of length = 2;
        for (int i = 0; i < n - 1; i++) {
            dp_palindrome[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        // all palindrome of length >= 3
        for (int len = 3; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                dp_palindrome[i][j] = (s.charAt(i) == s.charAt(j) && dp_palindrome[i + 1][j - 1]);
            }
        }
    }

    // Center Expansion Approach
    static int pal_count;

    public static void countPalindrome(String s) {
        int n = s.length();
        pal_count = 0;
        for (int i = 0; i < n; i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }
    }

    public static void check(String s, int i, int j) {
        int n = s.length();
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            pal_count++;
            i--;
            j++;
        }
    }

}
