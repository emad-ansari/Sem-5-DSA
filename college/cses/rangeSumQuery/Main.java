package cses.rangeSumQuery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer t = new StringTokenizer(br.readLine());


            int n = Integer.parseInt(t.nextToken());
            int q = Integer.parseInt(t.nextToken());

            long[] arr = new long[n];
            t = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(t.nextToken());
            }
            long[] pref = new long[n];
            pref[0] = arr[0];
            for (int i = 1; i < n; i++) {
                pref[i] = pref[i - 1] + arr[i];
            }
            StringBuilder sb = new StringBuilder();
            
            while (q-- != 0) {
                String[] range = br.readLine().split(" ");
                int l = Integer.parseInt(range[0]);
                int r = Integer.parseInt(range[1]);
                long ans = querySum(pref, l - 1, r - 1);
                sb.append(ans).append('\n');
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            bw.write(sb.toString());
            bw.flush();
        }

    }
    public static long querySum(long[] pref, int l, int r) {
        if (l == 0) {
            return pref[r];
        }
        else return pref[r] - pref[l - 1];
    }

}
