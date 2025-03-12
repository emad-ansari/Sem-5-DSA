package medium;

// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/ [SOVLED]

public class FindingMinimumInRotatedSortedArray {
    
    public static int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        
        int s = 0, e = nums.length - 1;
        if (nums[e] > nums[s]) return nums[s];
        while (s < e) {
            int m = s + (e - s) / 2;
            if (m < e && nums[m] > nums[m + 1]) return nums[m + 1];
            else if (m > s &&  nums[m] < nums[m - 1]) return nums[m];
            if (nums[m] > nums[s]) {
                if (nums[e] < nums[s]) s = m + 1;
                else e = m - 1;
            }
            else e = m  - 1;
        }
        return s;
    }
}
