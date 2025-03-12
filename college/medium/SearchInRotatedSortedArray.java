package medium;



// https://leetcode.com/problems/search-in-rotated-sorted-array/description/ [SOLVED]

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1};
        int[] nums1 = {12, 15, 18, 2, 5, 6, 8, 10};
        System.out.println("Target Index: " + findTargetInRotatedSortedArray(nums, 1));
        // 12, 15, 18, 2, 5, 6, 8, 10
    
    }

   
    // First Approach
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


    // Second Method: First finding the pivot index and then reducing search space based on pivot index;
    public static int search2(int[] nums, int t) {
        int pivot = findPivot(nums);
        if (pivot == -1 ) return -1;
        if (nums[pivot] == t) return pivot;

        if  (t > nums[0]) {
            return binarySearch(nums, 0, pivot - 1, t);
        }
        else return binarySearch(nums, pivot + 1, nums.length - 1, t);
    }
    public static int findPivot(int[] nums) {
        if (nums.length == 1) return 0;
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + ( e - s) / 2;
            if (e > m && nums[m] > nums[m + 1]) return m;
            else if (m > s && nums[m] < nums[m - 1]) return m - 1;
            else if (nums[m] >= nums[s]) s = m + 1;
            else e = m - 1;
        }
        return -1;
    }
    public static int binarySearch(int[] nums, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == t) return m;
            else if (t < nums[m]) e = m - 1;
            else s = m + 1;
        }
        return -1;
    }

    // third approach
    public static int findTargetInRotatedSortedArray(int[] nums, int target) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) return m;
            else if (nums[m] > nums[s]) {
                // means the first part is sorted
                if (target >= nums[s] && target <= nums[m]) e = m - 1;
                else s = m + 1;
            }
            else {
                // second  part is sorted
                if (target >= nums[m] && target <= nums[e]) s = m + 1;
                else e = m - 1;
            }
        }

        return -1;
    }

}
