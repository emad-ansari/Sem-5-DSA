package leetcode.easy;

import java.util.Arrays;

public class RemoveElement {
    public static void main(String[] args) {
        int [] nums = {0,1,2,2,3,0,4,2};
        System.out.println(removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }
    public static int removeElement(int[] nums, int val) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                int j = nums.length - 1;
                while (j > i && nums[j] == val) j--;
                if (j <= i) {
                    k = j;
                    break;
                }
                else {
                     int temp  = nums[i];
                     nums[i] = nums[j];
                     nums[j] = temp;
                }
            }
        }
        return k;
    }
}
