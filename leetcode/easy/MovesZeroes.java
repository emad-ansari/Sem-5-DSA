package leetcode.easy;

import java.util.Arrays;
// https://leetcode.com/problems/move-zeroes/description/ [SOLVED]

public class MovesZeroes {
    public static void main(String[] args){
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println("After moving zero at end: " + Arrays.toString(nums));

    }
    public static void moveZeroes(int[] nums) {
        int l = 0;
        for (int r = 0; r < nums.length; r++){
            if (nums[r] != 0){
                // then swap l with r
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
            }
        }
    }
}
