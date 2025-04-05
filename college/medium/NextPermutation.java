package medium;

import java.util.Arrays;
// https://leetcode.com/problems/next-permutation/description/ [SOLVED]
public class NextPermutation {
    public static void main(String[] args) {
        
    }
    // NOT OPTIMIZED

    public void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        // sort the array from i + 1 to n - 1; and return
        if (i < 0) {
            Arrays.sort (nums, i + 1, n);
            return;
        }
        // find next greater element
        int j = search(nums, i + 1, n - 1, nums[i]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        Arrays.sort(nums, i + 1, n);
        // sort from i + 1 to n - 1;
    }
    private static int search (int[] nums, int s , int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (t < nums[m]) s = m + 1;
            else e = m - 1;
        }
        return e;
    }
    
}
