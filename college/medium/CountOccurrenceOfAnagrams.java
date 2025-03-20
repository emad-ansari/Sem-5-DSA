package medium;

public class CountOccurrenceOfAnagrams {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        System.out.println(search(pat, txt));
        
    }
    public static int search(String pat, String txt) {
        int[] f = new int[26];
        
        for (char c: pat.toCharArray()) f[c - 'a']++;
        
        int l = 0, r = 0, cnt = 0;        
        while (r < txt.length()) {
            f[txt.charAt(r) - 'a']--;
            if (r - l + 1 > pat.length()) {
                f[txt.charAt(l) - 'a']++;
                l++;
            }
            if (r- l + 1 == pat.length()){
                if (anagramFound(f, pat)) cnt++;
            }
            r++;
            
        }
        return cnt;
    }
    public static boolean  anagramFound(int[] freq, String pat) {
        for (char c: pat.toCharArray()) {
            if (freq[c - 'a'] != 0) return false;
        }
        return true;
    }
    
}
