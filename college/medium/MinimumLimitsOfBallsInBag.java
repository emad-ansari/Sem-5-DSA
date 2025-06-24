package medium;

// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/description/  [SOLVED]
public class MinimumLimitsOfBallsInBag {

    public static void main(String[] args) {
        int[] nums0 = {9};
        int[] nums = {2, 4, 8, 2};
        System.out.println(minimumSize(nums0, 2));
        System.out.println(minimumSize(nums, 4));
        
    }
    public static int minimumSize(int[] nums, int maxOperations) {
        int s = 1, e = 0;

        for (int num: nums) e = num > e ? num : e;
        
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (isPossible(nums, maxOperations, m)) e = m - 1;
            else s = m + 1;
        }
        return s;
    }
    private static boolean isPossible (int[] nums, int mop, int p) {
        int top = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > p) {
                top += Math.ceilDiv(nums[i], p) - 1;
                if (top > mop) return false;
            }
        } 
        return true;
    }

}
