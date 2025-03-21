package hard;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// https://leetcode.com/problems/sliding-window-maximum/  [SOLVED]

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int[] nums1 = {1};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums1, 1)));
    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> dq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int l = 0, r = 0, i = 0;
        while (r < n) {
            while (!dq.isEmpty() && dq.getLast() < nums[r]) dq.removeLast();
            dq.offer(nums[r]);
            if (r - l  + 1 > k) {
                if (dq.getFirst() == nums[l]) dq.removeFirst();
                l++;
            }
            if (r - l + 1 == k) ans[i++] = dq.peek();
            r++;
        }
        return ans;
    }
}
