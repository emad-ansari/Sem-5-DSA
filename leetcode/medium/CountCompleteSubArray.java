package leetcode.medium;

import java.util.HashMap;

// [SOLVED]: https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/

// [TODO]: OPTIMIZE IT
public class CountCompleteSubArray {
    public static void main(String[] args) {
        int[] nums = {5,5,5,5};
        System.out.println("Ans: " + countCompleteSubarray(nums));

    }
    public static int countCompleteSubarray(int[] nums) {
        int count = 0;
        HashMap<Integer, Integer> distinctItem = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            distinctItem.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = j; i < nums.length; i++) {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
                if (map.size() == distinctItem.size()) count++;
            }
        }

        return count;
    }
}
