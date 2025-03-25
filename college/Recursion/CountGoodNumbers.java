package Recursion;

// https://leetcode.com/problems/count-good-numbers/  [SOLVED]

public class CountGoodNumbers {
    static final int M = 1000000007;    
    public static void main(String[] args) {
        System.out.println(countGoodNumbers(1));
        System.out.println(countGoodNumbers(4));
    }
    
    public static  int countGoodNumbers(long n) {
        long e = (n+ 1) / 2;
        long o =  n / 2;
        return (int)((calpow(5, e) * calpow(4, o)) % M);
    }

    public static long calpow(long n, long r) {
        if (r == 0) return 1;
        long a = calpow(n, r / 2);
        long ans = (a * a) % M;
        if (r % 2 == 1) ans = (ans * n) % M;
        return ans;
    }
    
}
