package Recursion;

// check whether a string is palindrome or not using recursion
public class Palindrome {
    public static void main(String[] args) {
        String s = "abcb";
        System.out.println(isPalindrome(s, 0, s.length() - 1));
        
    }
    public static boolean isPalindrome(String s, int l, int r) {
        if (l > r) return true;
        if (s.charAt(l) != s.charAt(r)) return false;
        return isPalindrome(s, l + 1, r - 1);
    }
    
}
