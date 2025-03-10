package Easy;

import java.util.HashMap;
import java.util.Arrays;

// https://leetcode.com/problems/majority-element/description/  [SOLVED]

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3,2,3};
        System.out.println(majorityElement2(nums));
    }

    public static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int majority = nums[0], maxFreq = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (maxFreq < map.get(nums[i])) {
                maxFreq = map.get(nums[i]);
                majority = nums[i];
            }
        }
        return majority;
    }

    // More Optimized Solution.
    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);

        int cnt = 1, prevCnt = 1,  maj = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                cnt++;
                if (cnt > prevCnt) {
                    prevCnt = cnt;
                    maj = nums[i];
                }
            }
            else cnt = 1;
        }
        return maj;

    }
}
