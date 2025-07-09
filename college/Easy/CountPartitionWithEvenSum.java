package Easy;

// https://leetcode.com/problems/count-partitions-with-even-sum-difference/
public class CountPartitionWithEvenSum {
     public int countPartitions(int[] nums) {
        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pref[i] =  nums[i] + pref[i - 1];
        }

        int count = 0;

        for (int i = 1; i < n; i++) {
            int leftSum = pref[i];
            int rightSum  = pref[n - 1] - pref[i + 1 - 1];
            if ((leftSum - rightSum) % 2 == 0) count++;
        }
        return count;
    }
    
}
