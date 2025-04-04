package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/description/ [SOLVED]
public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));

    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
   
    public static void backtrack(int[] nums, int ts, int i, List<Integer> list, List<List<Integer>> ans) {
        if (ts == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
     
        // can include
        if (i >= nums.length || ts < 0) return;
        list.add(nums[i]);
        backtrack(nums, ts - nums[i], i + 1,  list, ans);
        list.removeLast();
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        backtrack(nums, ts, i + 1, list, ans);
    }
}
