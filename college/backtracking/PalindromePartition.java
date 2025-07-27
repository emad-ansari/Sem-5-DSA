package backtracking;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/

public class PalindromePartition {
    public static void main(String[] args) {
        
    }
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        fxn(s, 0, new ArrayList<>(), res);
        return res;
    }
    public void fxn (String s, int i, List<String> list, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int p = i; p < s.length(); p++) {
            if (isPalindrome(s, i, p)) {
                list.add(s.substring(i, p + 1));
                fxn(s, p + 1, list, res);
                list.remove(list.size() - 1);
            }
        }
    }

    public boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
    
}
