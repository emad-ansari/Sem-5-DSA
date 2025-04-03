package Recursion;
public class SumOfDigits {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(sumOfDigits(n));
    }


    // Non- Tail recurion
    public static int sumOfDigits(int n) {
        if (n == 0) return 0;
        return n % 10 + sumOfDigits(n / 10);
    }
    // using tail recursion
    public static int helper(int n, int sum) {
        if (n == 0) return sum;
        return helper(n / 10, sum + n % 10);
    }
}
