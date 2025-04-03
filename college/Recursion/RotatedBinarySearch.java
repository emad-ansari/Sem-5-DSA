package Recursion;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9, 1, 2};
        System.out.println(findTarget(nums, 12));

    }
    public static int findTarget(int[] nums, int t) {
        return helper(nums, t, 0, nums.length - 1);
    }
    public static int helper(int[] nums, int t, int s, int e) {
        if (s > e) return -1;
        int m = s + (e - s) / 2;
        if (nums[m] == t) return m;
        else if (nums[m] > nums[s]) {
            // means left part is sorted. 
            if (t >= nums[s] && t < nums[m]) return helper(nums, t, s, m - 1);
            else return helper(nums, t, m + 1, e);
        }
        else {
            // means right part is sorted.
            if (t > nums[m] && t <= nums[e]) {
                return helper(nums, t, m + 1, e);
            }
            else return helper(nums, t, s, m - 1);
        }
    }
}
