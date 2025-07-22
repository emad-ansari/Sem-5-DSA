package Recursion;

/*
 * Mod Power
 * Time Complexity: O(log(b))
 */
public class Pow {
    static int MOD = (int)(1e9);
    public static void main(String[] args) {
        int a = 5;
        int b = 2;

        System.out.println(fastPow(a, b));
        
    }
    public static long pow(int a, int b) {
        if (b == 0) return 1;

        long p = pow(a, b / 2);
        long ans = (p * p) % MOD;
        if (b % 2 == 1) ans = (a * ans) % MOD;
        return ans;
    }
    // iterative approach
    public static long fastPow(int a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
        return res;
    }
    
}
