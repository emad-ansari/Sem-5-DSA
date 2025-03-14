package medium;

// https://leetcode.com/problems/minimized-maximum-of-products-distributed-to-any-store/description/  [SOLVED]
public class MinimizeMaximumOfProductDistibutedToAnyStore {
    public static void main(String[] args) {
        int[] quantities1 = { 11, 6 };
        int[] quantities2 = { 15, 10, 10 };
        int[] quantities3 = { 5, 7 };
        

        System.out.println(minimizedMaximum(6, quantities1));
        System.out.println(minimizedMaximum(7, quantities2));
        System.out.println(minimizedMaximum(2, quantities3));

    }

    public static int minimizedMaximum(int n, int[] quantities) {
        int s = 1, e = 0;
        for (int q : quantities)
            e = q > e ? q : e;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (canDistributed(quantities, n, m))
                e = m - 1;
            else
                s = m + 1;
        }
        return s;
    }

    private static boolean canDistributed(int[] quantities, int n, int pq) {
        int ts = 0;
        for (int i = 0; i < quantities.length; i++) {
            ts += Math.ceilDiv(quantities[i], pq);
            if (ts > n)  return false;
        }
        return true;
    }
}
