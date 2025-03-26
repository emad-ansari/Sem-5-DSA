package slidingwindow;

// https://leetcode.com/problems/subarray-product-less-than-k/description/  [SOLVED]
public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {0,5,2,6};
        int[] nums1 ={1, 2, 3};
        System.out.println(numSubarrayProductLessThanK(nums, 100));
        System.out.println(numSubarrayProductLessThanK(nums1, 0));
        
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int  l = 0, r = 0, p = 1, n = nums.length;
        int cnt = 0;

        while (r < n) {
            p *= nums[r];

            while (p >= k && l < n) {
                p /= nums[l];
                l++;
            }
            if (p < k) cnt += r - l + 1;
            r++;
        }   
        return cnt;

    }
}
