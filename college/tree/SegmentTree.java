package tree;
import java.util.Scanner;
public class SegmentTree {
    private int[] arr;
    private int[] seg;

    SegmentTree (int size) {
        arr = new int[size];
        seg = new int[4 * size];
    }

    public void buildTree(int s, int e, int i) { 
        if (s == e) {
            seg[i] = arr[s];
            return;
        }
        int m = s  + (e - s) / 2;
        buildTree(s, m, 2 * i + 1);
        buildTree(m + 1, e, 2 * i + 2);
        seg[i] = Math.max(seg[2 * i + 1], seg[2 * i + 2]);
    }

    public int getMax(int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) return seg[i];
        if (s < l  ||e > r) return Integer.MIN_VALUE; // outside
        else{
            int m = s + (e - s) / 2;  
            int left = getMax(s, m, l, r, 2 * i + 1);
            int right = getMax(m + 1, e, l, r, 2 * i  + 2);
            return Math.max(left, right);
        }
    }

    public void update(int idx, int s, int e, int i, int val) {
        if (s == e) {
            arr[s] = val;
            seg[idx] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if (i  >= s && i <= m) {
            // go left subtree
            update(2 * idx + 1, s, m, i, val);
        }
        else {
            // go right subtree
            update(2 * idx + 2, m + 1, e, i, val);
        }
        seg[idx] = Math.max(seg[2 * idx + 1], seg[2 * idx + 2]);
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        SegmentTree st = new SegmentTree(n);
        // fill the arr
        for (int i = 0; i < n; i++) {
            st.arr[i] = in.nextInt();
        }

        st.buildTree(0, n - 1, 0);
        // input number of queries
        int q = in.nextInt();
        while (q-- != 0) {
            // call query method
            int l = in.nextInt();
            int r = in.nextInt();
            System.out.println(st.getMax(0, n - 1, l, r, 0));
        }
        in.close();
    }
}
