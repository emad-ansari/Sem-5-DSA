package tree.segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

// https://cses.fi/problemset/task/1647
public class MinimumRangeQuery {
    public static void main(String[] args) throws IOException {
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer t = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());

            int[] nums = new int[n];
            t = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(t.nextToken());
            }
            int[] seg = new int[4 * n];
            // build tree
            
            buildTree(seg, nums, 0, n - 1, 0);
            StringBuilder sb = new StringBuilder();
            while (q-- != 0) {
                String[] range = br.readLine().split(" ");
                int l = Integer.parseInt(range[0]) - 1;
                int r = Integer.parseInt(range[1]) - 1;
                int ans = findMin(seg, 0, n - 1, l , r, 0);
                sb.append(Integer.toString(ans)).append('\n');
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        }
    }

    public static int findMin(int[] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) return seg[i];
        else if (r < s || e < l) return Integer.MAX_VALUE;
        else {
            int m = s + (e - s) / 2;
            int left = findMin(seg, s, m, l, r, 2 * i + 1);
            int right = findMin(seg, m + 1, e, l, r, 2 * i + 2);
            return Math.min(left, right);
        }
    }
    public static void buildTree(int[] seg, int[] nums, int s, int e, int i) {
        if (s == e) {
            seg[i] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;
        buildTree(seg, nums, s, m, 2 * i + 1);
        buildTree(seg, nums, m + 1, e, 2 * i + 2);

        seg[i] = Math.min(seg[2 * i + 1], seg[2 * i + 2]);
    }

    
}
