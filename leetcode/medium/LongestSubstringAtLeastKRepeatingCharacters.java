package leetcode.medium;


import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtLeastKRepeatingCharacters {
    public static void main(String[] args){
        String s = "aaabb";
        System.out.println("Ans: " + longestSubstring(s, 3));
    }
    public static int longestSubstring(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);
            // if each  char in the map have frequencies >= k then update the maxlength
            if (isValidSubstring(map, k)){
                maxLength = Math.max(maxLength, r - l + 1);
            }
            r++;
        }
        r = r - 1;
        while (l < s.length()) {
            char c = s.charAt(l);
            map.put(c, map.get(c) - 1);
            if (map.get(c) == 0) map.remove(c);
            if (isValidSubstring(map, k)) {
                maxLength = Math.max(maxLength, r - l + 1);
            }
            l++;
        }
        return maxLength;

    }
    public static boolean isValidSubstring(HashMap<Character, Integer> map, int k) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() < k) return false;
        }
        return true;
    }
}
