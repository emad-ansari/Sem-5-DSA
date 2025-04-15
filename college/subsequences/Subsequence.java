package subsequences;

// https://leetcode.com/problems/is-subsequence/description/ [SOLVED]
public class Subsequence {

    // Recursive way
    public boolean isSubsequenceWithRec(String s, String t) {
        return helper(s, t, 0, 0);
    }
    public boolean helper(String s, String t,  int i, int j) {
        if (j == s.length()) return true;
        if (i == t.length()) return false;

        if (s.charAt(j) == t.charAt(i)) {
            return helper(s, t, i + 1, j+ 1);
        }
        else return helper(s, t, i+ 1, j);
    }

    // Iterative way
    public boolean isSubsequence(String t, String s) {
        int n = s.length(), m = t.length(), i = 0, j = 0;

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            }
            else i++;
        }
        if (j == m) return true;
        return false;

    }
}
