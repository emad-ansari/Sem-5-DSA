package tree.segmenttree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://codeforces.com/problemset/problem/295/A
public class Codeforce295A {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] first = br.readLine().split(" ");
            String[] arr = br.readLine().split(" ");
            int n = Integer.parseInt(first[0]);
            int m = Integer.parseInt(first[1]);
            int k = Integer.parseInt(first[2]);
            long[] nums = new long[n];
            for (int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(arr[i]);
            int[][] operations = new int[m][3];
            int j = 0;
            while (j < m) {
                String[] op = br.readLine().split(" ");
                operations[j][0] = Integer.parseInt(op[0]) - 1;
                operations[j][1] = Integer.parseInt(op[1]) -1;
                operations[j][2] = Integer.parseInt(op[2]);
                j++;
            }
            // now opeation has been store
            long[] qd = new long[m];
            while (k-- != 0) {
                String[] query = br.readLine().split(" ");
                int l = Integer.parseInt(query[0]) - 1;
                int r = Integer.parseInt(query[1]) - 1;
                update(qd, l, r, 1);
            }
            // re-store the query diff array
            for (int i = 1; i < m; i++) qd[i] = qd[i - 1] + qd[i];

            long[] diff = new long[n];
            diff[0] = nums[0];
            // fill the difference array
            for (int i = 1; i < n; i++) diff[i] = nums[i] - nums[i - 1];

            // now perform query
            for (int i = 0; i < qd.length; i++) {
                int[] op = operations[i];
                int l = op[0];
                int r = op[1];
                long val = op[2] * qd[i];
                update(diff, l, r, val);
            }
            // now finally we got our diff array ready
            // now re-store it to get the actual answer
            for (int i = 1; i < n; i++) diff[i] = diff[i - 1] + diff[i];

            // now print the array
            for (long num: diff) {
                System.out.print(num + " ");
            }
        }
    }

    public static void update(long[] d, int l, int r, long val) {
        int n = d.length;
        d[l] += val;
        if (r < n - 1)
            d[r + 1] -= val;
    }

}
