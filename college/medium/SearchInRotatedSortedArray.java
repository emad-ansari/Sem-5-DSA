package medium;

// https://leetcode.com/problems/search-in-rotated-sorted-array/description/ [SOLVED]

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1};
        System.out.println("Target Index: " + search(nums, 6));


    }
    public static int search(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) return m;
            if (nums[m] >= nums[s] && nums[s] > nums[e]) {
                // I am in first half of the array
                if (target < nums[m] && target >= nums[s]) e = m - 1;
                else s = m + 1;
            }
            else {
                // I am second half of the sorted array
                if (target > nums[m] && target <= nums[e]) s = m + 1;
                else e = m - 1;
            }
           
        }
        return -1;
    }
    

}
