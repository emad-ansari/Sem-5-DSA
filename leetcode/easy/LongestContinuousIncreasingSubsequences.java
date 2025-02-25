package leetcode.easy;


// [SOLVED]: https://leetcode.com/problems/longest-continuous-increasing-subsequence/description/
public class LongestContinuousIncreasingSubsequences {
    public static void main (String[] args) {
        int[] nums = {1,3,5,4,7};
        System.out.println("Ans: " + findLengthOfLCIS(nums));

    }
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 1) return 1;
        int l = 0;
        int r = 1;
        int longestIncreasing = 1;
        while (r < nums.length) {
            if (nums[r] > nums[r - 1]) {
                longestIncreasing = Math.max(longestIncreasing, r -l + 1);
                r++;
            }
            else {
                l = r;
                r = r + 1;
            }
        }
        return longestIncreasing;
    }
}
