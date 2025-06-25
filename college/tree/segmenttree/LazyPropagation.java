package tree.segmenttree;

import java.util.Scanner;

public class LazyPropagation {
    int[] seg, lazy;

    LazyPropagation(int size) {
        this.seg = new int[4 * size];
        this.lazy = new int[4 * size];
    }

    public void buildTree(int[] nums, int s, int e, int i) {
        if (s == e) {
            this.seg[i] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;
        buildTree(nums, s, m, 2 * i + 1);
        buildTree(nums, m + 1, e, 2 * i + 2);
        this.seg[i] = this.seg[2 * i + 1] + this.seg[2 * i + 2];
    }

    public void update(int s, int e, int l, int r, int i, int val) {
        // first update the lazy node
        if (this.lazy[i] != 0) {
            // means there is update, so first update these
            this.seg[i] += (e - s + 1) * this.lazy[i];
            // propagate the update downwards
            // check if there is child of current node or not
            if (s != e) {
                // means there are child of current node
                lazy[2 * i + 1] += this.lazy[i];
                lazy[2 * i + 2] += this.lazy[i];
            }
            this.lazy[i] = 0;
        }
        // No overlap condition --> s e l r or l r s e
        if (e < l || r < s)
            return;
        else if (s >= l && e <= r) { // complete overlap --> l s e r
            this.seg[i] = (e - s + 1) * val;
            // propagate the updates downwards
            if (s != e) {
                this.lazy[2 * i + 1] += val;
                this.lazy[2 * i + 2] += val;
            }
            return;

        } else {
            // partial overlap
            int m = s + (e - s) / 2;
            update(s, m, l, r, 2 * i + 1, val);
            update(m + 1, e, l, r, 2 * i + 2, val);
        }

        this.seg[i] = this.seg[2 * i + 1] + this.seg[2 * i + 2];
    }

    public int query(int s, int e, int l, int r, int i) {
        if (this.lazy[i] != 0) {
            // udpate it and propagate the udpates downwards
            this.seg[i] += (e - s + 1) * this.lazy[i];
            if (s != e) {
                this.lazy[2 * i + 1] += this.lazy[i];
                this.lazy[2 * i + 2] += this.lazy[i];
            }
            this.lazy[i] = 0;
        }
        if (e < l || r < s)
            return 0;
        if (s >= l && e <= r)
            return seg[i];

        int m = s + (e - s) / 2;
        int left = query(s, m, l, r, 2 * i + 1);
        int right = query(m + 1, e, l, r, 2 * i + 2);
        return left + right;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        LazyPropagation lz = new LazyPropagation(n);
        lz.buildTree(nums, 0, n - 1, 0);
        int q = in.nextInt();
        StringBuilder sb = new StringBuilder();
        while (q-- != 0) {
            int type = in.nextInt(); // type == 1 --> means update and 2 means range query
            
            if (type == 1) {
                int l = in.nextInt();
                int r = in.nextInt();
                int val = in.nextInt();
                lz.update(0, n - 1, l, r, 0, val);
            }
            else {
                int l = in.nextInt();
                int r = in.nextInt();
                int ans = lz.query(0, n - 1, l, r, 0);
                sb.append(ans).append('\n');
            }
        }
        System.out.println(sb.toString());
        in.close();
    }

}
