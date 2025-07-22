package strings;

// https://leetcode.com/problems/delete-characters-to-make-fancy-string
public class FancyString {
    public String makeFancyString(String s) {
        int len = s.length();
        if (len == 1 || len == 2) return s;

        char[] arr = s.toCharArray();

        int freq = 1, k = 1;
        arr[0] = s.charAt(0);

        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) freq++;
            else freq = 1;

            if (freq >=3 ) continue;
            arr[k++] = arr[i];
        }

        return new String(arr, 0, k);
    }
    
}
