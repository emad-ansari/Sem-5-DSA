package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;

// [SOLVED]: https://leetcode.com/problems/count-complete-subarrays-in-an-array/description/

// [TODO]: OPTIMIZE IT
public class CountCompleteSubArray {
    public static void main(String[] args) {
        int[] nums = {5,5,5,5};
        int[] nums1 = {1,3,1,2,2};
        
        System.out.println("Ans: " + countCompleteSubarray1(nums1));

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

    // OPTIMIZED SOLUTION
    public static int countCompleteSubarray1(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, ngs = 0, n = nums.length;

        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.size() == set.size()) {
                ngs += n - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            r++;
        }
        return ngs;   
    }
}
