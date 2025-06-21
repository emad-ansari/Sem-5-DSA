package subarray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;


public class SubArraySum2 {
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
            HashMap<Long, Integer> map = new HashMap<>();
            map.put(0L, 1);
            for (int i = 0; i < n; i++) {
                sum += nums[i];
                if (map.containsKey(sum - x)) {
                    count += map.get(sum - x);
                }
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }

            System.out.println(count);
        }   
    }
    
}
