package tree.segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
// https://cses.fi/problemset/result/13406644/

public class DyanmicRangeMinimum {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer token = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(token.nextToken());
            int q = Integer.parseInt(token.nextToken());
            int [] nums = new int[n];
            token = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(token.nextToken());
            }
            int[] seg = new int[4 * n];
            buildTree(seg, nums, 0, n - 1, 0);
            StringBuilder sb = new StringBuilder();

            while (q-- != 0) {
                token = new  StringTokenizer(br.readLine());
                int type = Integer.parseInt(token.nextToken());
                if (type == 1) {
                    int k = Integer.parseInt(token.nextToken()) - 1;
                    int u = Integer.parseInt(token.nextToken());
                    update(seg, 0, n - 1, 0, k, u);
                }
                else {
                    int l = Integer.parseInt(token.nextToken()) - 1;
                    int r = Integer.parseInt(token.nextToken()) - 1;
                    int ans = findMin(seg, 0, n- 1, l, r, 0);
                    sb.append (ans).append('\n');
                }
                
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        }
    }



    public static void buildTree(int[] seg, int[] nums, int s, int e, int i) {
        if (s == e) {
            seg[i] = nums[s];
            return;
        }
        int m = s + (e - s ) / 2;
        buildTree(seg, nums, s, m, 2 * i + 1);
        buildTree(seg, nums, m + 1, e, 2 * i + 2);

        seg[i] = Math.min(seg[2 * i + 1], seg[2 * i + 2]);
    }
    public static void update(int[] seg, int s, int e, int i, int index, int val){
        if (s == e) {
            seg[i] = val;
            return;
        }
        int m = s + (e - s) / 2;
        if (index <= m) {
            update(seg, s, m, 2 * i + 1, index, val);
        }
        else update(seg, m + 1, e, 2 * i + 2, index, val);

        seg[i] = Math.min(seg[2 * i + 1], seg[2 * i + 2]);
    }

    public static int findMin(int[] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) return seg[i];
        else if (e < l || r < s) return Integer.MAX_VALUE;
        else {
            int m = s + (e - s) / 2;
            int left = findMin(seg, s, m, l, r, 2 * i + 1);
            int right = findMin(seg, m + 1, e, l, r, 2 * i + 2);
            return Math.min(left, right);
        }
    }
}
