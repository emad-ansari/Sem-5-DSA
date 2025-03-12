package Easy;

import java.util.HashMap;
import java.util.Arrays;

// https://leetcode.com/problems/majority-element/description/  [SOLVED]

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums1 = {3,2,3};
        int[] nums2 = {2,2,1,1,1,2,2};
        int[] nums3 = {2, 2, 2, 2, 2};
        int[] nums4 = {4, 5, 6, 4, 4, 4, 4};
        int[] nums5 = {7, 7, 7, 1, 2, 7, 7, 3, 7};

        System.out.println(majElement(nums1));
        System.out.println(majElement(nums2));
        System.out.println(majElement(nums3));
        System.out.println(majElement(nums4));
        System.out.println(majElement(nums5));
        // System.out.println(majElement(nums6));
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

    // Optimized Solution.
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

    // In Linear Time (More Optimized)
    public static int majElement (int[] nums) {
        int currNum = nums[0];
        int cnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == currNum) cnt++;
            else {
                if (cnt == 0) {
                    currNum = nums[i];
                    cnt = 1;
                }
                else cnt--;
            }
        }
        return currNum;
    }
}
