package tree.segmenttree;

import java.io.*;
import java.util.StringTokenizer;

public class SerajaAndBracket {

    static final Node EMPTY = new Node(0, 0, 0);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] brackets = br.readLine().toCharArray();
        int q = Integer.parseInt(br.readLine());
        int n = brackets.length;

        // Segment Tree Initialization
        Node[] seg = new Node[4 * n];
        for (int i = 0; i < seg.length; i++) seg[i] = new Node(0, 0, 0);
        buildTree(brackets, seg, 0, n - 1, 0);

        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            Node ans = findFull(seg, 0, n - 1, l, r, 0);
            sb.append(ans.full * 2).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
    }

    public static void buildTree(char[] brackets, Node[] seg, int s, int e, int i) {
        if (s == e) {
            seg[i].open = brackets[s] == '(' ? 1 : 0;
            seg[i].close = brackets[s] == ')' ? 1 : 0;
            seg[i].full = 0;
            return;
        }
        int m = (s + e) / 2;
        buildTree(brackets, seg, s, m, 2 * i + 1);
        buildTree(brackets, seg, m + 1, e, 2 * i + 2);
        seg[i] = merge(seg[2 * i + 1], seg[2 * i + 2]);
    }

    public static Node findFull(Node[] seg, int s, int e, int l, int r, int i) {
        if (r < s || e < l) return EMPTY;
        if (l <= s && e <= r) return seg[i];

        int m = (s + e) / 2;
        Node left = findFull(seg, s, m, l, r, 2 * i + 1);
        Node right = findFull(seg, m + 1, e, l, r, 2 * i + 2);
        return merge(left, right);
    }

    public static Node merge(Node left, Node right) {
        int matched = Math.min(left.open, right.close);
        return new Node(
                left.open + right.open - matched,
                left.close + right.close - matched,
                left.full + right.full + matched
        );
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
