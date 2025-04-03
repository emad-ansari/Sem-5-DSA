package Recursion;

public class ProductOfDigits {
    public static void main(String[] args) {
        int n = 12345;
        System.out.println(productOfDigits(n));
    }
    public static int productOfDigits(int n) {
        if (n % 10 == n) return n;
        return (n % 10 ) * productOfDigits(n / 10);
    }
}
