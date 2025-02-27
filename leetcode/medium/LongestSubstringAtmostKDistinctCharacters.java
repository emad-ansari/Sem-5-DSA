package leetcode.medium;

import java.util.HashMap;

public class LongestSubstringAtmostKDistinctCharacters {
    public static void main(String[] args) {
        String str = "aaabbccd";
        System.out.println("Result: " + longestSubstring(str, 2));

    }
    public static int longestSubstring(String s, int k) {
        int l = 0;
        int r = 0;
        int max_length = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            if (map.size() <= k) {
                max_length = Math.max(max_length, r - l + 1);
                r++;
            }
            else {
                char lc = s.charAt(l);
                map.put(lc, map.get(lc) - 1);
                if(map.get(lc) == 0) map.remove(lc);
                l++;
            }
        }
        return max_length;
    }
}
