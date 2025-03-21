package hard;

// https://leetcode.com/problems/minimum-window-substring/description/  [SOLVED]
public class MinimumWindowSubstring {
    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(minWindow(s, t));
        
    }
    public static String minWindow(String s, String t) {
        int[] map = new int[123];
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        for (char c: tc) map[c]++;
        int l = 0, r = 0, mini = 0,  minl = Integer.MAX_VALUE, tcc = t.length();
        while (r < s.length()) {
            if (map[sc[r]] > 0) tcc--;
            map[sc[r]]--;
            while (tcc == 0) {
                if (r - l + 1 < minl) {
                    minl = r - l + 1;
                    mini = l;
                }                
                map[sc[l]]++;
                if (map[sc[l]] > 0) tcc++;
                l++;
            }
            r++;
        }
       return minl == Integer.MAX_VALUE ? "" : s.substring(mini, mini + minl);
    }  
}
