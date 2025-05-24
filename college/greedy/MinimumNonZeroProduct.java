package greedy;

// https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/description/  [SOLVED]
public class MinimumNonZeroProduct {
    public static final int m = 1000000007;

    public static void main(String[] args) {
        System.out.println(minNonZeroProduct(3));
    }

    public static int minNonZeroProduct(int p) {
        long max = ((long) 1 << p) - 1;
        long res = pow(max - 1, (max - 1) / 2);
        res = ((res % m) * (max % m)) % m;
        return (int) res;
    }

    public static long pow(long a, long b) {
        if (b == 0) return 1;
        long temp = pow(a, b / 2);
        temp = temp % m;
        if (b % 2 == 0) return (temp * temp) % m;
        else {
            return (((temp * temp) % m) * (a % m)) % m;
        }
    }

}
