package greedy;

// https://leetcode.com/problems/split-a-string-in-balanced-strings

public class SplitString {
    public int balancedStringSplit(String s) {
        int cnt_l = 0, cnt_r = 0, balanced_cnt = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'L')
                cnt_l++;
            else
                cnt_r++;

            if (cnt_l == cnt_r)
                balanced_cnt++;
        }
        return balanced_cnt;
    }

}
