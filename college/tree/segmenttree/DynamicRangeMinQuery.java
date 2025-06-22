package tree.segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// https://cses.fi/problemset/result/13405380/

public class DynamicRangeMinQuery {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer t = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());

            int[] nums = new int[n];
            t = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(t.nextToken());
            }
            long[] seg = new long[4 * n];
            // build tree

            buildTree(seg, nums, 0, n - 1, 0);
            StringBuilder sb = new StringBuilder();
            while (q-- != 0) {
                String[] range = br.readLine().split(" ");
                int type = Integer.parseInt(range[0]);
                if (type == 1) {
                    int k = Integer.parseInt(range[1]) - 1;
                    int u = Integer.parseInt(range[2]);
                    update(seg, 0, n - 1, 0, k, u);
                }
                else {
                    int l = Integer.parseInt(range[1]) - 1;
                    int r = Integer.parseInt(range[2]) - 1;
                    long ans = querySum(seg, 0, n - 1, l, r, 0);
                    sb.append(ans).append('\n');
                }
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        }

    }


    public static void update(long[] seg, int s, int e, int i, int index, int val) {
        if (s == e) {
            seg[i] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if (index <= m) {
            update(seg, s, m, 2 * i + 1, index, val);
        }
        else update(seg, m + 1, e, 2 * i + 2, index, val);

        seg[i] = seg[2 * i + 1] + seg[2 * i + 2];
    }

    public static long querySum(long[] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r)
            return seg[i];
        else if (r < s || e < l)
            return 0;
        else {
            int m = s + (e - s) / 2;
            long left = querySum(seg, s, m, l, r, 2 * i + 1);
            long right = querySum(seg, m + 1, e, l, r, 2 * i + 2);
            return left + right;
        }
    }

    public static void buildTree(long[] seg, int[] nums, int s, int e, int i) {
        if (s == e) {
            seg[i] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;
        buildTree(seg, nums, s, m, 2 * i + 1);
        buildTree(seg, nums, m + 1, e, 2 * i + 2);

        seg[i] = seg[2 * i + 1] +  seg[2 * i + 2];
    }

}
