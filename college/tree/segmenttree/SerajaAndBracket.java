package tree.segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SerajaAndBracket {

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

            char[] brackets = br.readLine().toCharArray();
            int q = Integer.parseInt(br.readLine());
            int n = brackets.length;

            int size = (int) Math.pow(2, n); // 1 << n

            // build the tree over here
            Node[] seg = new Node[4 * size];
            for (int i = 0; i < seg.length; i++) {
                seg[i] = new Node(0, 0, 0);
            }

            buildTree(brackets, seg, 0, n - 1, 0);
            StringBuilder sb = new StringBuilder();
            while (q-- != 0) {
                String[] query = br.readLine().split(" ");
                int l = Integer.parseInt(query[0]) - 1;
                int r = Integer.parseInt(query[1]) - 1;
                Node ans = findFull(seg, 0, n - 1, l, r, 0);
                sb.append(ans.full * 2).append('\n');
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        }

    }

    public static void buildTree(char[] brackets, Node[] seg, int s, int e, int i) {
        if (s == e) {
            seg[i].open = brackets[s] == '(' ? 1 : 0;
            seg[i].close = brackets[s] == ')' ? 1 : 0;
            seg[i].full = 0;
            return;
        }
        int m = s + (e - s) / 2;
        buildTree(brackets, seg, s, m, 2 * i + 1);
        buildTree(brackets, seg, m + 1, e, 2 * i + 2);
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        seg[i] = merge(seg[l], seg[r]);
    }

    public static Node findFull(Node[] seg, int s, int e, int l, int r, int i) {
        if (l <= s && e <= r) {
            return seg[i];
        } else if (r < s || e < l) {
            return new Node(0, 0, 0);
        }

        int m = s + (e - s) / 2;
        Node left = findFull(seg, s, m, l, r, 2 * i + 1);
        Node right = findFull(seg, m + 1, e, l, r, 2 * i + 2);
        return merge(left, right);

    }

    public static Node merge(Node left, Node right) {
        Node node = new Node(0, 0, 0);
        int correct = Math.min(left.open, right.close);

        node.full = left.full + right.full + correct;
        node.open = left.open + right.open - correct;
        node.close = left.close + right.close - correct;
        return node;
    }

}

class Node {
    int open, close, full;

    Node(int open, int close, int full) {
        this.open = open;
        this.close = close;
        this.full = full;
    }
}
