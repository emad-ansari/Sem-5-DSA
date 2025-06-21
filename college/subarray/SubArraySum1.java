package subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubArraySum1 {
    public static void main(String[] args)  throws IOException{
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int[] nums = new int[n];
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(arr[i]);
            }

            // sliding window
            long count = 0;
            long sum = 0;
            int l = 0, r = 0;
            while (r < n) {
                sum += nums[r];
                // expand the window
                while (sum > x ) {
                    sum -= nums[l];
                    l++;
                }
                if (sum == x) count++;
                r++;
            }

            System.out.println(count);
        }   
    }
}
