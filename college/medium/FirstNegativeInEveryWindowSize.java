package medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

// https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1  [SOLVED]

public class FirstNegativeInEveryWindowSize {
    public static void main(String[] args) {
        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
        int[] nums1 = {-8, 2, 3, -6, 10};
        System.out.println(firstNegativeInteger(nums, 3));
        System.out.println(firstNegativeInteger(nums1, 2));
    }
    public static List<Integer> firstNegativeInteger(int nums[], int k) {
        // write code here
        Deque<Integer> dq = new ArrayDeque<>();
        List<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        while (r < nums.length) {
            if (nums[r] < 0) dq.offer(nums[r]);
            while (r - l + 1 > k) {
                if (!dq.isEmpty() && dq.peek() == nums[l]) dq.removeFirst();
                l++;
            }
            if (r - l + 1 == k) {
                if (dq.isEmpty()) ans.add(0);
                else ans.add(dq.getFirst());
            }
            r++;
            
        }
        return ans;
    }
}
