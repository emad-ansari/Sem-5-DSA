package subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/ [SOLVED]
public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));

    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        return helper(candidates, target, new ArrayList<>(), new ArrayList<>(), 0);
    }
    public static List<List<Integer>> helper(int[] nums, int ts, List<Integer> list, List<List<Integer>> ans, int i) {
        if (i == nums.length) {
            if (ts == 0) {
                ans.add(new ArrayList<>(list));
            }
            return ans;
        }
     
        // can include
        if (nums[i] <= ts) {
            list.add(nums[i]);
            helper(nums, ts - nums[i], list, ans, i);
            list.remove(list.size() - 1);
        }

        helper(nums, ts, list, ans, i + 1);
        return ans;
    }
}
