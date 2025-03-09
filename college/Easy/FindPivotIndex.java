package Easy;

// https://leetcode.com/problems/find-pivot-index/  [SOLVED]

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1, 7, 3, 6, 5, 6};
        int[] nums1 = {1,2,3};
        int[] nums2 = {2,1,-1};
        System.out.println(pivotIndex(nums));
        System.out.println(pivotIndex(nums1));
        System.out.println(pivotIndex(nums2));
        
    }
    public static int pivotIndex(int[] nums) {
        // first calculate the pref sum 
        int[] pref = new int[nums.length];
        pref[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pref[i] = nums[i] + pref[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            int leftSum =  i == 0 ? 0 : pref[i - 1];
            int rightSum  = i == nums.length - 1 ? 0 : pref[nums.length - 1] - nums[i] - leftSum;
            if (leftSum == rightSum) return i;
        }
        return -1;
    }
}
