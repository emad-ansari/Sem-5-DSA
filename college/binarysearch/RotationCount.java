package binarysearch;

public class RotationCount {
    public static void main(String[] args) {
        int[] nums = {5,1,2,3,4};
        System.out.println(countArrayRotation(nums));
    }
    public static int countArrayRotation(int[]  nums) {
        int n = nums.length;
        if (nums[0] < nums[n - 1]) return 0;
        // your answer will be pivot + 1
        int p = findPivot(nums);
        return p;
    }
    public static int findPivot(int[] nums) {
        int s = 0, e = nums.length - 1;
        // find the pivot index
        while (s <= e) {
            int m = s + (e - s) / 2;
            if ((m > s && nums[m] < nums[m - 1]) && (m < e && nums[m] < nums[m + 1])) return m;
            else if (m < e && nums[m] > nums[m + 1]) return m + 1; 
            else if (nums[m] > nums[s]) {
                // means i am in first part of the sorted array
                // so i need to go ahead
                s = m + 1;
            }
            else if (nums[m] < nums[s]) e = m - 1;
        }
        return s;
    }
    
    
}
