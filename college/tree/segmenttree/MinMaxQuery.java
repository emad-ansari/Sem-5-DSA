package tree.segmenttree;

// https://www.geeksforgeeks.org/problems/range-min-max-queries4557/0

public class MinMaxQuery {
    public int[] getMinMax(int[] arr, int L, int R, int[][] segTree) {
        int n = arr.length;
        return getValue(segTree, 0, n - 1, L, R, 0);

    }

    public int[] getValue(int[][] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) {
            return new int[] { seg[i][0], seg[i][1] };
        }
        if (e < l || r < s) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };
        } else {
            int m = s + (e - s) / 2;
            int[] left = getValue(seg, s, m, l, r, 2 * i + 1);
            int[] right = getValue(seg, m + 1, e, l, r, 2 * i + 2);
            return new int[] { Math.min(left[0], right[0]), Math.max(left[1], right[1]) };
        }
    }
    public void updateValue(int[] arr, int index, int value, int[][] segTree) {
        // code here
        arr[index] = value;
        int n = arr.length;
        update(segTree, 0, n - 1, 0, index, value);
    }

    public void update(int[][] seg, int s, int e, int idx, int index, int val) {
        if (s == e) {
            seg[idx][0] = val;
            seg[idx][1] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if (index <= m) {
            // go left subtree
            update(seg, s, m, 2 * idx + 1, index, val);
        } else {
            // go right subtree
            update(seg, m + 1, e, 2 * idx + 2, index, val);
        }
        seg[idx][0] = Math.min(seg[2 * idx + 1][0], seg[2 * idx + 2][0]);
        seg[idx][1] = Math.max(seg[2 * idx + 1][1], seg[2 * idx + 2][1]);
    }

}
