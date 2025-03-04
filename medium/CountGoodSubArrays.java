package medium;
import java.util.HashMap;


public class CountGoodSubArrays {
    public static void main(String[] args) {
        // 3 1 4 3 2 2 4
        // - - - - - - 

    }

    public static long countGood(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int l = 0;
        int r = 0;
        int pairs = 0;
        while (r < nums.length) {
            pairs += map.getOrDefault(nums[r], 0);
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            if (pairs >= 2) {
                res += nums.length - r;
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
                
            }
            r++;
        }

        return res;
    }
    
}
