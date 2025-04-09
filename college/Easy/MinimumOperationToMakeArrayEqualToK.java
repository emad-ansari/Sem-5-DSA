package Easy;

// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/description/?envType=daily-question&envId=2025-04-09  [SOLVED]

public class MinimumOperationToMakeArrayEqualToK {
    public static void main(String[] args) {
        int[] nums1 = {5,2,5,4,5};
        int[] nums2 = {2,1,2};
        int[] nums3 = {9,7,5,3};
        System.out.println(minOperations(nums1, 2));
        System.out.println(minOperations(nums2, 2));
        System.out.println(minOperations(nums3, 1));

        
    }
    public static int minOperations(int[] nums, int k) {
        boolean[] freq = new boolean[101];
        int min = nums[0], d = 0;
        for (int num: nums) {
            min = Math.min(min, num);
            if (!freq[num]){
                freq[num] = true;
                d++;
            }
        }
        if (k > min) return -1;
        if (k < min) return d;
        return d - 1;
    }
    
}
