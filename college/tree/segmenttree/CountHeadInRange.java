package tree.segmenttree;

import java.util.*;
import java.io.*;

public class CountHeadInRange {
    Node[] seg;
    boolean[] lazy;

    CountHeadInRange(int size) {
        seg = new Node[4 * size];
        lazy = new boolean[4 * size];
    }

    class Node {
        int head, tail;

        Node(int head, int tail) {
            this.head = head;
            this.tail = tail;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        // build tree
        CountHeadInRange ob = new CountHeadInRange(n);
        ob.buildTree(nums, 0, n - 1, 0);
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());
        while (q-- != 0) {
            // input the query

        }

        bw.flush();
        bw.close();
    }

    public void buildTree(int[] nums, int s, int e, int i) {
        if (s == e) {
            int head = nums[i] == 1 ? 1 : 0;
            int tail = nums[i] == 0 ? 1 : 0;
            this.seg[i] = new Node(head, tail);
            return;
        }
        int m = s + (e - s) / 2;
        buildTree(nums, s, m, 2 * i + 1);
        buildTree(nums, m + 1, e, 2 * i + 2);
        this.seg[i] = merge(2 * i + 1, 2 * i + 2);
    }

    public void update(int s, int e, int l, int r, int i) {
        if (this.lazy[i]) {
            // need to update and propagete the update down below
            flipHeadAndTail(i);
            if (s != e) {
                this.lazy[2 * i + 1] = true;
                this.lazy[2 * i + 2] = true;
            }
            this.lazy[i] = false;
            return;
        }
        if (r < s || e < l)
            return;
        if (l <= s && e <= r) {
            flipHeadAndTail(i);

            if (s != e) {
                this.lazy[2 * i + 1] = true;
                this.lazy[2 * i + 2] = true;
            }
            return;
        }
        // partial overlap
        int m = s + (e - s) / 2;
        update(s, m, l, r, 2 * i + 1);
        update(m + 1, e, l, r, 2 * i + 2);
        // now merge the changes
        this.seg[i] = merge(2 * i + 1, 2 * i + 2);
    }

    public int findHead(int s, int e, int l, int r, int i) {
        if (lazy[i]) {
            // udpate it
            flipHeadAndTail(i);
            if (s != e) {
                this.lazy[2 * i + 1] = true;
                this.lazy[2 * i + 2] = true;
            }
            this.lazy[i] = false;
        }
        if (r < s || e < l)
            return 0;
        if (l <= s && e <= r)
            return seg[i].head;
        // partial overlap
        int m = s + (e - s) / 2;
        int left = findHead(s, m, l, r, 2 * i + 1);
        int right = findHead(m + 1, e, l, r, 2 * i + 2);
        // now merge the changes
        return left + right;
    }

    public void flipHeadAndTail(int i) {
        int head = this.seg[i].head;
        this.seg[i].head = this.seg[i].tail;
        this.seg[i].tail = head;
    }

    public Node merge(int l, int r) {
        int thc = this.seg[l].head + this.seg[r].head;
        int ttc = this.seg[l].tail + this.seg[r].tail;
        return new Node(thc, ttc);
    }

}