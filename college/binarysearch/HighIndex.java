package binarysearch;

// https://leetcode.com/problems/h-index/description/ [solved]

public class HighIndex {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(hIndex(nums));
    }
    public static int hIndex(int[] citations) {
        int maxhi = 0;
        int s = 0, e = citations.length;
        while (s <= e) {
            int m = s + ( e - s) / 2;
            if (helper(citations, m)) {
                maxhi = Math.max(maxhi, m);
                s = m + 1;
            }
            else e = m - 1;
        }
        return maxhi;

  
    }
    public static boolean isExistAtleastH(int[] nums, int hi) {
        int cnt = 0;
        for (int num: nums) {
            if (num >= hi) cnt++;
            if (cnt >= hi) return true;
        }
        return false;
    }

    // H-Index 2
    public static boolean helper(int[] nums, int hi) {
        int n = nums.length, s = 0, e = n - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (hi <= nums[m]) e = m - 1;
            else s = m + 1;
        }
        return (n - s) >= hi;
    }    
}
