package medium;

// https://leetcode.com/problems/single-element-in-a-sorted-array/description/  [SOVLED]
public class SingleElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(nums));
        
        
    }
    public static int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] != nums[1]) return nums[0];
        if (nums[n - 1] != nums[n - 2]) return nums[n - 1];

        int s = 1, e = n - 2;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] != nums[m - 1] && nums[m] != nums[m + 1]) return nums[m];
            else if ((m % 2 == 1 && nums[m] == nums[m + 1]) || (m % 2 == 0 && nums[m] == nums[m - 1])) e = m - 1;
            else s = m + 1;
        }
        return -1;
    }
    
}
