package rangequery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class CountDistinctElement {
    static int SIZE;

    static class Node implements Comparable<Node> {
        int l, r, i;

        Node(int l, int r, int i) {
            this.l = l;
            this.r = r;
            this.i = i;
        }

        @Override
        public int compareTo(Node a) {
            int block1 = this.l / SIZE;
            int block2 = a.l / SIZE;
            if (block1 != block2) {
                return Integer.compare(block1, block2);
            }
            // Within the same block, alternate sort order based on block number
            return (block1 % 2 == 0) ? Integer.compare(this.r, a.r) : Integer.compare(a.r, this.r);
        }
    }

    public static void main(String[] args) throws IOException {
        try (
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            int n = Integer.parseInt(br.readLine());
            SIZE = (int) Math.sqrt(n);

            int[] nums = new int[n];
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }

            int q = Integer.parseInt(br.readLine());
            Node[] queries = new Node[q];

            for (int i = 0; i < q; i++) {
                String[] query = br.readLine().split(" ");
                int l = Integer.parseInt(query[0]) - 1;
                int r = Integer.parseInt(query[1]) - 1;
                queries[i] = new Node(l, r, i);
            }

            Arrays.sort(queries);

            int[] freq = new int[1000001];
            int[] ans = new int[q];

            int curr_l = 0, curr_r = -1, distinct = 0;

            for (Node query : queries) {
                int l = query.l;
                int r = query.r;

                while (curr_r < r) {
                    curr_r++;
                    if (freq[nums[curr_r]] == 0) distinct++;
                    freq[nums[curr_r]]++;
                }

                while (curr_r > r) {
                    freq[nums[curr_r]]--;
                    if (freq[nums[curr_r]] == 0) distinct--;
                    curr_r--;
                }

                while (curr_l < l) {
                    freq[nums[curr_l]]--;
                    if (freq[nums[curr_l]] == 0) distinct--;
                    curr_l++;
                }

                while (curr_l > l) {
                    curr_l--;
                    if (freq[nums[curr_l]] == 0) distinct++;
                    freq[nums[curr_l]]++;
                }

                ans[query.i] = distinct;
            }

            for (int res : ans) {
                bw.write(res + "\n");
            }
            bw.flush();
        }
    }
}