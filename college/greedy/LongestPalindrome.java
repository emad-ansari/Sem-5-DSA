package greedy;
// [done]
public class LongestPalindrome {
    public static void main(String[] args) {
        String s  = "abccccdd";
        System.out.println(s);
    }
    public static int longestPalindrome(String s) {
        int[] freq = new int[123];

        for (char ch: s.toCharArray()) {
            freq[ch]++;
        }
        boolean isOne = false;
        int maxLen = 0;
        for (int num: freq) {
            if (num == 1 || num % 2 != 0) isOne = true;
            if (num % 2 != 0) maxLen += num-1;
            else maxLen += num;
        }
        if (isOne) maxLen += 1;
        return maxLen;
    }
    
}
