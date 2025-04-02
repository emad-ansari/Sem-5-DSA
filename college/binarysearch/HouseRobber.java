package binarysearch;

// https://leetcode.com/problems/house-robber-iv/description/?envType=daily-question&envId=2025-03-15  [SOLVED]
public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2,3,5,9};
        System.out.println(minCapability(nums, 2));

    }
    public static int minCapability(int[] nums, int k) {
        int min = nums[0], max = nums[0];
        for (int num: nums) {
            max = num > max ? num : max;
            min = num < min ? num : min;
        }
        int s = min, e = max, minc = Integer.MAX_VALUE;
        while (s <= e) {
            int m =  s + (e - s) / 2;
            if (isPossible(nums, k, m)) {
                minc = Math.min(minc, m);
                e = m - 1;
            }
            else s = m + 1;
        }
        return minc;

    }

    // optimized one
    public static boolean isPossible1(int[] nums, int k, int minC) {
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= minC) {
                cnt++;
                i++;
            }
            if (cnt >= k) return true;
        }
        return false;
    }
    public static boolean isPossible(int[] nums, int k, int minC) {
        int cnt = 0, n = nums.length, prevI = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= minC) {
                if (i == 0) {
                    cnt++;
                    prevI = i;
                   
                }
                else if (i > 0 && i - 1 != prevI) {
                    prevI = i;
                    cnt++;

                }
                if (cnt >= k) return true;
            }
            
        }
        return false;
    }
}
