package rangequery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class DistinctElement {
    static final int SIZE = 500;

    static class Node implements Comparable<Node> {
        int l, r, i;

        Node(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }

        @Override
        public int compareTo(Node a) {
            if (this.l != a.l / SIZE) {
                return Integer.compare(this.l / SIZE, a.l / SIZE);
            } else {
                return Integer.compare(this.r, a.r);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(br.readLine());

            int[] nums = new int[n];
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            int q = Integer.parseInt(br.readLine());
            Node[] queries = new Node[q];

            int i = 0;

            while (q-- != 0) {
                String[] query = br.readLine().split(" ");
                int l = Integer.parseInt(query[0]) - 1;
                int r = Integer.parseInt(query[1]) - 1;
                queries[i] = new Node(l, r, i++);
            }
            // write comparator
            Arrays.sort(queries);

            int[] freq = new int[1000001];
            int[] ans = new int[queries.length];

            int curr_l = 0, curr_r = -1, distinct = 0;
            StringBuilder sb = new StringBuilder();
            for (Node query : queries) {
                int l = query.l;
                int r = query.r;

                while (curr_r < r) {
                    curr_r++;
                    if (++freq[nums[curr_r]] == 1) distinct++; 
                }
                while (l < curr_l) {
                    curr_l--;
                    if (++freq[nums[curr_l]] == 1) distinct++; 
                }
                while (r < curr_r) {
                    if (--freq[nums[curr_r]] == 0) distinct--; 
                    curr_r--;
                }
                while (curr_l < l) {
                    if (--freq[nums[curr_l]] == 0) distinct--; 
                    curr_l++;
                }
                ans[query.i] = distinct;
            }
            for (int res: ans) {
                sb.append(res).append('\n');
            }

            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        }
    }

}
