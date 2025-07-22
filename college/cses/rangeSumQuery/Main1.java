package cses.rangeSumQuery;

import java.util.ArrayList;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main1 {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] first = br.readLine().split(" ");
            String[] second = br.readLine().split(" ");

            int n = Integer.parseInt(first[0]);
            int q = Integer.parseInt(first[1]);

            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(second[i]);
            }

            int sqrt = (int) Math.sqrt(n);

            List<Long> pref = new ArrayList<>(); 

            int chunkId = -1;
            for (int i = 0; i < n; i++) {
                if (i % sqrt == 0) chunkId++;
                pref.set(chunkId, pref.get(chunkId) + arr[i]);
            }
            System.out.println(pref);

            while (q-- != 0) {
                String[] range = br.readLine().split(" ");
                int l = Integer.parseInt(range[0]);
                int r = Integer.parseInt(range[1]);
                System.out.println(querySum(arr, pref, l - 1, r - 1));
            }
        }

    }

    public static long querySum(long[] nums, List<Long> pref, int l, int r) {
        long res = 0;
        int sqrt = (int)Math.sqrt(nums.length);
        while (l % sqrt != 0 && l < r && l != 0) {
            res += nums[l++]; // left part;
            
        }
        while (l + sqrt <= r) { // middle part
            res += pref.get(l / sqrt);
            l += sqrt;
        }
        while (l <= r)
            res +=  pref.get(l++);  // right part
        return res;
    }
}
