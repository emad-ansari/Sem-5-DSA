package subarray;

import java.util.HashMap;

public class ContiguousSubarray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 1, 1, 0, 0, 0};
        System.out.println(findMaxLength(nums));
    }

    // brute force approach
    public static int findMaxLength1(int[] nums) {
        int n = nums.length, maxLen = 0;
        for (int i = 0; i  < n ;i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == 1) count++;
                else count--;

                if (count == 0) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }

            }
        }
        return maxLen;
    }
    // better
    public static int findMaxLength(int[] nums) {
        int n = nums.length, maxLen = 0, count = 0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        map.put(count , -1);
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) count--;
            else count++;

            if (map.containsKey(count)) {
                maxLen = Math.max(maxLen, i - map.get(count));
            }
            else map.put(count, i);
        }
        return maxLen;
    }


}
