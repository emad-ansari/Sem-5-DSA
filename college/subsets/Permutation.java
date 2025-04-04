package subsets;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/permutations/description/ [SOLVED]
public class Permutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), res);
        return res;
    }
    public static void backtrack(int[] nums, List<Integer> list, List<List<Integer>> res) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int num: nums) {
            if (!list.contains(num)){
                list.add(num);
                backtrack(nums, list, res);
                list.removeLast();
            }
        }
    }
}
