package Easy;

public class BinaarySearch {
    public static void main(String[] args) {
        // int[] nums = {1, 2, 2, 3, 4, 10};
        // System.out.println("ans: " + binarySearch(nums, 2));
        int[] nums = {2,5,6,0,0,1,2};
        System.out.println("Ans: " + findPivotIndexInRotatedSortedArray(nums));
        
    }
    public static int binarySearch(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s  + (e - s) / 2;
            if (nums[m] == target) return m;
            else if(target > nums[m]) s = m + 1;
            else e = m - 1;
        }
        return -1;
    }

    public static int findPivotIndexInRotatedSortedArray(int[] nums) {
        int s = 0, e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] >= (m - 1 < 0 ? nums[m] : nums[m - 1]) && nums[m] > (m + 1 == nums.length ? nums[m] : nums[m + 1])) return m;
            if (nums[m] >= nums[s] && nums[s] >= nums[e]) {
                // you are in first part of the array
                s = m + 1;
            }
            else  {
                // you are in second part of the array
                // move left
                e = m - 1;
            }
        }
        return -1;
    }
}
