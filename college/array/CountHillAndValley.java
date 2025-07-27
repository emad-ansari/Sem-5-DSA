package array;

// https://leetcode.com/problems/count-hills-and-valleys-in-an-array

public class CountHillAndValley {
    public int countHillValley(int[] nums) {
        int n = nums.length;
        int countHillOrValley = 0;

        for (int i = 1; i < n - 1; i++) {
            if (nums[i] == nums[i - 1]) continue;
            int j = i + 1;
            while (j < n && nums[j] == nums[i]) j++;
            
            boolean isHill = j < n && nums[i] > nums[i - 1] && nums[i] > nums[j];
            boolean isValley = j < n && nums[i] < nums[i - 1] && nums[i] < nums[j];

            if (isHill || isValley) {
                countHillOrValley++;
            }
        }
        return countHillOrValley;
    }
    
}
