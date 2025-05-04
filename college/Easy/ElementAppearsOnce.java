package Easy;

// https://leetcode.com/problems/single-element-in-a-sorted-array/ [SOLVED]
public class ElementAppearsOnce {
    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(findSingleElement(nums));

    }
    public static int findSingleElement(int[] nums) {
        
        int n = nums.length, s = 0, e = n - 1;
        if (n == 1 || nums[0] != nums[1]) return nums[0];
        if ( nums[n - 1] != nums[n - 2]) return nums[n - 1];
        while (s <= e) {
            int m = s + (e - s) / 2;
            if ((m < e && nums[m] != nums[m + 1]) && (m > s && nums[m] != nums[m - 1])) return nums[m];
            if ((m % 2 != 0 && nums[m] == nums[m + 1]) || (m % 2 == 0 && nums[m] == nums[m - 1])) e = m - 1;
            else s = m + 1;
        }
        return nums[e];
    }
}
