package medium;

// https://leetcode.com/problems/find-the-duplicate-number/description/ [SOLVED]
public class FindDuplicates {

    public static void main(String[] args) {
        int[] nums = {18,13,14,17,9,19,7,17,4,6,17,5,11,10,2,15,8,12,16,17};
        int[] nums1 = {3, 1, 3, 4, 2};
        System.out.println(findDuplicate(nums));
        System.out.println(findDuplicate(nums1));
    }
    public static int findDuplicate(int[] nums) {
        int s = 0, f = 0;
        while (true) {
            s = nums[s];
            f = nums[nums[f]];
            if (s == f) break;
        }
        f = 0;
        while (f != s) {
            s = nums[s];
            f = nums[f];
        }
        return f;
    }

}
