package medium;

// [solved]
public class ZeroArrayTransform {
    public static void main(String[] args) {
        // int[][] queries = {{2,2, 1}, {2,2,3}, {1,2, 5}, {0, 1, 2}};
        // int[] nums = {0, 4, 3};
        int[] nums = {1, 2, 1, 0, 0, 0};
        int[][] queries = {{0, 3}, {2, 4}};
        System.out.println(isZeroArray(nums, queries));
        // System.out.println(minZeroArray(nums, queries));
    }
  

    public static boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] d = new int[n];
        d[0] = nums[0];
        for (int i =  1; i < n; i++) d[i] = nums[i] - nums[i - 1];
        
        for (int[] query: queries) {
            int l = query[0], r = query[1];
            d[l]--;
            if (r  < n - 1) d[r + 1] ++;
        }
        if (d[0] > 0) return false;
        for (int i = 1; i < n; i++) {
            d[i] = d[i] + d[i - 1];
            if (d[i] > 0) return false;
        }
        return true;
    }
    

}
