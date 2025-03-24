package Easy;

import java.util.Arrays;

public class DiffArray {
    public static void main(String[] args) {
        int[] nums = {10, 5, 20, 40 };
        int[][] queries = {{0, 1, 10}, {1, 3, 20}, {2, 2, 30}};
        updateRange(nums, queries);
    }
    
    // Difference Array concept
    public static void updateRange(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] d = new int[n];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) d[i] = nums[i] - nums[i - 1];

        for (int[] query: queries) {
            int l = query[0], r = query[1], val = query[2];
            d[l] += val;
            if (r < n - 1) d[r + 1] -= val;
        }
        for (int i = 1; i < n; i++) d[i] = d[i - 1] + d[i];
        System.out.println(Arrays.toString(d));
    }
    // Decrementing ith item with x in range [l, r]
    public static void updaterRange2(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] d = new int[n];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) d[i] = nums[i] - nums[i - 1];


    }

    
}
