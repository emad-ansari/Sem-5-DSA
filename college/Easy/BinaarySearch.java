package Easy;

public class BinaarySearch {
    public static void main(String[] args) {
        
        // int[] nums = {2,5,6,0,0,1,2};
        int[] nums1 = {4, 5, 6, 6, 7, 7, 0, 1, 2, 3};

        System.out.println("Ans: " + findPivot(nums1));

        // 4,5,6,7,0,1,2
        // 
        
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
    public static int findPivot(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0;
        if ((nums[0] == nums[n - 1] ) && nums[0] > nums[1]) return 0;
        
        int s = 0, e = n - 1;
        while (s < e) {
            int m = s + (e - s)  /2;
            if (nums[m] > (m - 1 < 0 ? Integer.MIN_VALUE : nums[m - 1]) && nums[m] > (m + 1 == n ? Integer.MIN_VALUE : nums[m + 1])) return m;
            else if (nums[m] >= nums[0] && nums[s] >= nums[n - 1]) s = m + 1;
            else e = m - 1;
        }
        return s;
    }
}
