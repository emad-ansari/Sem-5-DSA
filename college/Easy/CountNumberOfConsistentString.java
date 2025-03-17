package Easy;

import java.util.HashMap;

public class CountNumberOfConsistentString {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad","bd","aaab","baa","badab"};
        System.out.println(countConsistentStrings(allowed, words));
        
    }
    public static  int countConsistentStrings(String allowed, String[] words) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: allowed.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int cnt = 0;
        
        for (String s: words) {
            boolean consis = true;
            for (char c: s.toCharArray()) {
                if (!map.containsKey(c)) consis = false;
            }
            if (consis == true) cnt++;
        }
        return cnt;
        
        
    }

    // OPTIMEZED
    public int countConsistentStrings1(String allowed, String[] words) {
        boolean[] map = new boolean[26];
        for (char c: allowed.toCharArray()) map[c - 'a'] = true;

        int cnt = 0;
        
        for (String s: words) {
            boolean consis = true;
            for (char c: s.toCharArray()) {
                if (!map[c - 'a']) {
                    consis = false;
                    break;
                }
            }
            if (consis == true) cnt++;
        }
        return cnt;
    }
}
