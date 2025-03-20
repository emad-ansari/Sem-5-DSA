package medium;
// https://leetcode.com/problems/minimum-size-subarray-sum/description/  [SOLVED]
public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        
    }
    public int minSubArrayLen(int target, int[] nums) {
        int ml = Integer.MAX_VALUE;
        int l = 0, r = 0, sum  = 0;
        while (r < nums.length) {
            sum += nums[r];
            while (sum >= target) {
                ml = Math.min( ml, r-l + 1);
                sum = sum - nums[l];
                l++;
            }
            r++;
        }
        return ml == Integer.MAX_VALUE ? 0 : ml;
    }

}
