package tree.fenwicktree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class FenwickTree {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer t = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());

            int[] nums = new int[n];
            long[] BIT = new long[n + 1];
            t = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(t.nextToken());
            }

            BuildBIT(nums, BIT);
            StringBuilder sb = new StringBuilder();
            while (q-- != 0) {
                t = new StringTokenizer(br.readLine());
                int type = Integer.parseInt(t.nextToken());
                if (type == 1) {
                    int k = Integer.parseInt(t.nextToken()) - 1;
                    int u = Integer.parseInt(t.nextToken());
                    long diff = u - nums[k];
                    update(diff, k, BIT);
                    nums[k] = u;
                } else {
                    int l = Integer.parseInt(t.nextToken()) - 1;
                    int r = Integer.parseInt(t.nextToken()) - 1;
                    long ans = 0L;
                    if (l == 0) {
                        ans = query(BIT, r);
                    } else {
                        ans = query(BIT, r) - query(BIT, l - 1);
                    }
                    sb.append(ans).append('\n');

                }  
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter((System.out)));
            bw.write(sb.toString());
            bw.flush();
        }   

    }

    public static void update(long diff, int i, long[] BIT) {
        int n = BIT.length;
        i++;
        while (i <= n) {
            BIT[i] += diff;
            i = i + (i & (-i));
        }
    }

    public static void BuildBIT(int[] nums, long[] BIT) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            update(nums[i], i, BIT);
        }
    }

    public static long query(long[] BIT, int i) {
        long res = 0;
        i++;
        while (i > 0) {
            res += BIT[i];
            i = i - (i & (-i));
        }
        return res;
    }
}