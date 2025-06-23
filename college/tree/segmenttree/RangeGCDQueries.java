package tree.segmenttree;

// https://www.geeksforgeeks.org/problems/range-gcd-queries3654/1
public class RangeGCDQueries {
    public static int findRangeGcd(int l, int r, int st[], int n) {
        // Your code here
        return getGcdInRange(st, 0, n - 1, l, r, 0);
    }

    public static int getGcdInRange(int[] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) {
            return seg[i];
        } else if (e < l || r < s)
            return 0;
        else {
            int m = s + (e - s) / 2;
            int left = getGcdInRange(seg, s, m, l, r, 2 * i + 1);
            int right = getGcdInRange(seg, m + 1, e, l, r, 2 * i + 2);
            return gcd(left, right);
        }
    }

    // Function to update a value in input array and segment tree.
    public static void updateValue(int index, int new_val, int arr[], int st[], int n) {
        // Your code here
        arr[index] = new_val;
        update(st, 0, n - 1, 0, index, new_val);

    }

    public static void update(int[] seg, int s, int e, int i, int index, int val) {
        if (s == e) {
            // update
            seg[i] = val;
            return;
        }

        int m = s + (e - s) / 2;
        if (index <= m) {
            update(seg, s, m, 2 * i + 1, index, val);
        } else
            update(seg, m + 1, e, 2 * i + 2, index, val);

        seg[i] = gcd(seg[2 * i + 1], seg[2 * i + 2]);
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
