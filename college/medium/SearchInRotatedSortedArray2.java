package medium;

import java.util.HashMap;

public class SearchInRotatedSortedArray2 {

    public static void main(String[] args) {
        // 2, 5, 6, 6 0, 0, 1, 2
        // 1, 0, 1, 1, 1,
        // int[] nums = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
        int[] arr = {2,2,2,0,2,2};
        System.out.println("Ans: "  + search2 (arr, 0));
        
    }
  
    // Brute force approach (for smaller array)
    public static boolean searchRotatedSortedArray2(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        return map.containsKey(target);
    }

    // optimized approach

    public static boolean search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1 ) return false;
        if (nums[pivot] == target) return true;

        if (target > nums[0]) {
            return helper(nums, 0, pivot - 1, target);
        }
        else return helper(nums, pivot + 1, nums.length - 1, target);

    }
    public static int findPivot(int[] nums) {
        if (nums.length == 1) return 0;

        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (e > m && nums[m] > nums[m + 1]) return m;
            else if (m > s && nums[m] < nums[m - 1]) return m -1;
            else if (nums[m] > nums[s]) s = m + 1;
            else if (nums[m] == nums[s] && nums[m] == nums[e]) s++;
            else e = m -1;
        }
        return -1;
    }

    public static boolean helper (int[] nums, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == t) return true;
            else if (t < nums[m]) e = m - 1;
            else s = m + 1;
        }
        return false;
    }

    public static boolean search2(int[] nums, int target) {
        int s = 0, e = nums.length -1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == target) return true;
            else if (nums[s] == nums[m] && nums[m] == nums[e]) {
                s++;
                e--;
                continue;
            }
            else if (nums[m] > nums[s]) {
                // means left part is sorte 
                if (target >= nums[s] && target <=nums[m]) e = m -1;
                else s = m  + 1;
            }
            else {
                // means right part is sorted
                if (target >= nums[m] && target <= nums[e]) s = m + 1;
                else e = m - 1;
            }
           
        }
        return false;
    }
    

}
