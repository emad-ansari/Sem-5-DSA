package tree.segmenttree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class XeniaAndBitOperation {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] first = br.readLine().split(" ");
            int n = Integer.parseInt(first[0]);
            int q = Integer.parseInt(first[1]);
            int size = (int) Math.pow(2, n);
            int[] nums = new int[size];
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < size; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }
            // build the tree over here
            int[] seg = new int[4 * size];
            boolean op = n % 2 == 0 ? true : false;
            buildTree(nums, seg, 0, size - 1, 0, op); // false => OR & true => XOR

            while (q-- != 0) {
                String[] query = br.readLine().split(" ");
                int p = Integer.parseInt(query[0]);
                int b = Integer.parseInt(query[1]);

                // perform updation and print the answer
                update(seg, nums, 0, size - 1, p - 1, 0, b, op);
                System.out.println(seg[0]);
            }

        }
    }

    public static void buildTree(int[] nums, int[] seg, int s, int e, int i, boolean op) {
        if (s == e) {
            seg[i] = nums[s];
            return;
        }
        int m = s + (e - s) / 2;

        buildTree(nums, seg, s, m, 2 * i + 1, !op);
        buildTree(nums, seg, m + 1, e, 2 * i + 2, !op);

        if (!op) {
            // OR Operation
            seg[i] = seg[2 * i + 1] | seg[2 * i + 2];
        }
        else seg[i] = seg[2 * i + 1] ^ seg[2 * i + 2];
    }

    public static void update(int[] seg, int[] nums, int s, int e, int p, int i, int val, boolean op) {
        if (s == e) {
            seg[i] = val;
            nums[p]= val;
            return;
        }
        int m = s + (e - s) / 2;
        if (p <= m) {
            // go left
            update(seg,nums, s, m, p, 2 * i + 1, val, !op);
        }
        else {
            // go right
            update(seg,nums, m + 1, e, p, 2 * i + 2, val, !op);
        }

        // perform updation
        if (!op) {
            // OR Operation
            seg[i] = seg[2 * i + 1] | seg[2 * i + 2];
        }
        else seg[i] = seg[2 * i + 1] ^ seg[2 * i + 2];
    }

}
