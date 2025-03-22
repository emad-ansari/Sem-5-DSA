package medium;
import java.util.HashMap;

// https://leetcode.com/problems/count-the-number-of-good-subarrays/description/  [SOLVED]

public class CountGoodSubArrays {
    public static void main(String[] args) {
        // 3 1 4 3 2 2 4
        // - - - - - - 
        int[] nums = {3, 1, 4, 3, 2, 2, 4};
        int[] nums1 = {3,1,4,3,3,3,4};
        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println(countGood(nums, 2));
        System.out.println(countGood(nums1, 2));
        System.out.println(countGood(nums2, 10));

    }

    public static long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0, r = 0, n = nums.length; 
        
        long ngs = 0L, np = 0L;
        while (r < n) {
            int cf = map.getOrDefault(nums[r], 0);
            long cp = (long) cf * (cf - 1) / 2;
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            {
                int fa = map.get(nums[r]);
                long pa = (long) fa * (fa - 1) / 2;
                long  diff = pa - cp;
                np += diff;
            }
                
            // map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while(np >= k) {
                ngs += n - r;
                if (map.get(nums[l]) >= 1) {
                    int fb = map.get(nums[l]);
                    long pb = (long) fb * (fb - 1) / 2;
                    map.put(nums[l] , map.get(nums[l]) - 1);
                    int fa = map.get(nums[l]);
                    long pa = (long) fa * (fa - 1) / 2;
                    long cont = pb - pa;
                    np -= cont;
                }
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            r++;
        }

        return ngs;
    }
    
}
