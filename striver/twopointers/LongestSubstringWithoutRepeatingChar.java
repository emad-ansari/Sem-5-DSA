package striver.twopointers;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar {
    public static void main(String[] args){
        String str = "bbbb";
        System.out.println(findMaxLength(str));

    }
    public static int findMaxLength(String str) {
        int maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        while (r < str.length()) {
            int c = str.charAt(r);
            if (map.containsKey(c) && map.get(c) >= l) {
                l = map.get(c) + 1;
                map.put(map.get(c), r);
            }
            else {
                map.put(c, r);
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            }
        }
        return maxLength;
    }
}
