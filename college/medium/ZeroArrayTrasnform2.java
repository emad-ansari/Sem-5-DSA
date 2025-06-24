package medium;

public class ZeroArrayTrasnform2 {
    public static void main(String[] args) {
        int[] nums = {5};
        int[][] queries = {{0,0,5},{0,0,1}, {0,0,2}, {0,0,3}};
        System.out.println(minZeroArray1(nums, queries));
        
    }
    public static int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length, q = queries.length;
        boolean az = nums[0]  > 0 ? false : true;
        int[] d = new int[n];
        d[0] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > 0) az = false;
            d[i] = nums[i] - nums[i - 1];
        }

        if (az) return 0;
        // apply binary search here
        int s = 0, e = q - 1;
        while (s <= e) {
            int k = s + (e - s) / 2;
            if (canMakeZero(queries, d, nums, k)) e = k - 1;
            else s = k + 1;
        }

        return e == q - 1 ? -1 : s + 1;
    }
    public static boolean canMakeZero(int[][] queries, int[] d, int[] nums, int e) {
        for (int i = 0; i <= e; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            d[l] -= val;
            if (r < nums.length - 1) d[r + 1] += val;
        }
        return (hasBecomeZero(d, nums));
    }

    public static boolean hasBecomeZero(int[] d, int[] nums) {
        nums[0] = d[0];
        if (nums[0] > 0) return false;
        for (int i = 1; i < nums.length; i++) {
            nums[i] = d[i] + nums[i - 1];
            if (nums[i] > 0) return false;
        }
        return true;
    }

    // second method;
    public static int minZeroArray1(int[] nums, int[][] queries) {
        int l = 0, r = queries.length;
        while (l <= r) {
            int k = l + (r - l ) / 2;
            if (helper(queries, nums, k)) r = k - 1;
            else l = k + 1;
        }
        return r == queries.length ? -1 : l;
    }
    public static boolean helper(int[][] queries, int[] nums,  int k) {
        int n = nums.length;
        int[] d = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0], r = queries[i][1], val = queries[i][2];
            d[l] += val;
            d[r + 1] -= val;
        }
        // check wether it has become  zero or not
        int cs = 0;
        for (int i = 0; i < n; i++) {
            cs += d[i];
            if (cs < nums[i]) return false;
        }   
        return true;
    }
    

}
