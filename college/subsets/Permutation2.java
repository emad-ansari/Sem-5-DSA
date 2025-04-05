package subsets;

import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

// https://leetcode.com/problems/permutations-ii/description/ [SOLVED]

public class Permutation2 {
    static int[] freq = new int[21];
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2};
        System.out.println(permuteUnique1(nums));
        
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        for (int num: nums ) freq[num + 10]++;

        Set<List<Integer>> res = new HashSet<>();
        backtrack(nums, new ArrayList<>(), res);
        List<List<Integer>> ans = new ArrayList<>(res);
        return ans;
        
    }
    private static void backtrack(int[] nums, List<Integer> list, Set<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int num: nums) {
            if (freq[num + 10] > 0) {
                list.add(num);
                freq[num + 10]--;
                backtrack(nums, list, res);
                freq[num + 10]++;
                list.removeLast();
            }
        }
    }

    // OPTIMIZED ONE
    public static List<List<Integer>> permuteUnique1(int[] nums) {
        Arrays.sort(nums);
        for (int num: nums ) freq[num + 10]++;

        List<List<Integer>> res = new ArrayList<>();
        backtrack1(nums, new ArrayList<>(), res);

        return res;
        
    }
    private static void backtrack1(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i= 0; i < nums.length; i++) {
            while (i > 0 && nums[i] == nums[i - 1]) i++;
            if (i >= nums.length) break;
            if (freq[nums[i] + 10] > 0) {
                list.add(nums[i]);
                freq[nums[i] + 10]--;
                backtrack1(nums, list, res);
                freq[nums[i] + 10]++;
                list.removeLast();
            }
        }
    }
}
