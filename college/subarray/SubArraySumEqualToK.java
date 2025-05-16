package subarray;

import java.util.HashMap;

// https://leetcode.com/problems/subarray-sum-equals-k/ [solved]
public class SubArraySumEqualToK {
    public static void main(String[] args) {
        

    }
    public static  int subarraySum(int[] nums, int k) {
        int n = nums.length, prefSum = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int num: nums) {
            prefSum += num;
            int removed = prefSum - k;
            cnt += map.getOrDefault(removed, 0);
            map.put(prefSum, map.getOrDefault(prefSum, 0) + 1);
        }
        return cnt;
    }
    
}
