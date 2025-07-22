package Recursion;

public class PalindromeNumber {
    public static void main(String[] args) {
        // 12321
        int n = 111222111;
        System.out.println(isPalindrome(n));
    }
    public static boolean isPalindrome(int n) {
        return helper(n, (int) Math.log10(n) + 1, 0);

    }
    public static boolean helper(int n, int dl, int rev) {
        if (dl / 2 == (int) Math.log10(rev) + 1) {
            if (dl % 2 == 0) {
                if (rev == n) return true;
                return false;
            }
            else {
                // in case of odd
                n /= 10;
                if (n == rev) return true;
                return false;
            }
        }
        return helper(n / 10, dl, rev * 10 + n % 10);
    }

    // optimized version
    public static boolean check_palindrome(int n ) {
        if (n < 0 || (n != 0 && n  % 10 == 0)) return false;

        int rev = 0;
        while (n != 0) {
            rev = rev * 10 + n % 10;
            n /= 10;

            if (rev == n || rev == n / 10) return true;
        }
        return false;
    }
}
