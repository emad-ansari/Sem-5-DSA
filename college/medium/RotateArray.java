package medium;

// https://leetcode.com/problems/rotate-array/description/ [SOLVED]
public class RotateArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        rotate(nums, 3);
    }
    public static void rotate(int[] nums, int k) {
        helper(nums, k % nums.length, 0);
    }
    public static void helper (int[] nums, int k , int i) {
        if (i == nums.length) return;
        int l = nums[i];
        helper(nums, k, i + 1);
        int indx = (i + k) % nums.length;
        nums[indx] = l;
    }

    // OPTIMIZED ONE
    public static void rotate1(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        helper(nums, 0, n - 1);
        helper(nums, 0, k - 1);
        helper(nums, k, n - 1);
    }
    public static void helper1(int[] a , int l, int r) {
        while (l <= r) {
            swap(a, l, r);
            l++;
            r--;
        }
    }
    public static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
    
}
