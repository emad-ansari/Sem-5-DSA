package leetcode.easy;

//[SOLVED]:  https://leetcode.com/problems/consecutive-characters/description/
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        String str = "abbcccddddeeeeedcba";
        System.out.println(maxPower(str));

    }
    public static int maxPower(String s) {
        int l = 0;
        int r = 0;
        int maxLength = 0;
        while (r < s.length()) {
            if (s.charAt(r) == s.charAt(l)) {
                maxLength = Math.max(maxLength, r - l + 1);
                r++;
            }
            else l = r;
        }
        return maxLength;
    }
}
