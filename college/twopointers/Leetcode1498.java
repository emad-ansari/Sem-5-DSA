package twopointers;
import java.util.*;
// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/

public class Leetcode1498  {


   int M = (int)1e9 + 7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length, l = 0, r = n - 1;
        int cnt = 0;
        int[] pow2 = new int[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = (pow2[i - 1] * 2) % M;
        }

        while (l <= r) {
            if (nums[l] + nums[r] <= target) {
                cnt = (cnt + pow2[r - l]) % M;
                l++;
            }
            else r--;
        }
        return cnt;
    }
}