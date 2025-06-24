package medium;


public class MaxVowels {
    public static void main(String[] args) {
        String s = "leetcode";
        System.out.println();
        // System.out.println(maxVowels(s, 3));
    }
    public static int maxVowels(String s, int k) {
        int maxv = 0, l = 0, v = 0, r = k- 1;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))){
                v++;
                maxv = Math.max(maxv, v);
            }
        }

        while (r < s.length()) {
            if (isVowel(s.charAt(l))) v--;
            l++;
            r++;
            if (r < s.length() && isVowel(s.charAt(r))) v++;
            maxv = Math.max(maxv, v);
            if (maxv == k) break;
        }

        return maxv;
    }
    public static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    
}
