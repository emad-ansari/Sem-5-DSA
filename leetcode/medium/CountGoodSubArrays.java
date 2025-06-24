package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class CountGoodSubArrays {
    public static void main(String[] args) {
        int[] nums = {3,3, 4, 1, 2, 2, 3, 1, 4};
        System.out.println("Ans: " + countGood(nums, 2));
    }
    public static long countGood(int[] nums, int k) {
        long res = 0;
        for (int i = 0; i < nums.length; i++) {

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < nums.length; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
                int pairs = getPairs(map);
                if (pairs == k) {
                    res  = res + nums.length - j;
                    break;
                }
                if (pairs > k) {
                    res ++;
                }
            }

        }
        return res;
    }

    public static int getPairs(HashMap<Integer, Integer> map) {
        int pairs  = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() >= 2){
                pairs += (entry.getValue() * (entry.getValue() - 1)) / 2;
            }

        }
        return pairs;
    }
}
