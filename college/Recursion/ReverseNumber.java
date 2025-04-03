package Recursion;

public class ReverseNumber {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(reverseNumber(n));
    }
    // tail recursion
    public static int reverseNumber(int n) {
        int digits = (int)Math.log10(n) + 1;
        return helper1(n, digits);
    }
    public static int helper(int n, int ans) {
        if (n == 0) return ans;
        return helper(n / 10, ans * 10 + n % 10);
    }

    // Non-tail recursion
    public static int helper1(int n, int digits) {
        if (n == 0) return 0;

        return (n % 10) * (int)Math.pow(10, digits - 1) + helper1(n / 10, digits - 1);
        
    }

}
