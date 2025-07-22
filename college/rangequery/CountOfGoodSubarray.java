package rangequery;

import java.io.*;

public class CountOfGoodSubarray  {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] first = br.readLine().split(" ");

        int n = Integer.parseInt(first[0]);
        int k = Integer.parseInt(first[1]);
        int[] nums = new int[n];

        SIZE = (int) Math.sqrt(n);

        bw.flush();
        bw.close();
    }

}