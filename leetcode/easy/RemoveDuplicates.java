package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/

public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums = {-3, -1, 0, 0, 0, 3, 3};
        removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));

    }
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 1) return 1;
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}
