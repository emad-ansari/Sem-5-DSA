package subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/  [SOLVED]
public class Subset {
    public static void main(String[] args) {
        int[] nums = {4,2,5,3};
        System.out.println(subsets(nums));

        // List<Integer> list = new ArrayList<>();
        // List<List<Integer>> ans = new ArrayList<>();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // ans.add(list);

        // System.out.println(list);
        // System.out.println(ans);
        // list.remove(2);
        // System.out.println(list);
        // list.add(4);
        // System.out.println(list);
        // System.out.println(ans);

        
    }
    public static List<List<Integer>> subset(int[] nums) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            int n = outer.size();
            for (int j = 0; j < n; j++) {
                List<Integer> inner = new ArrayList<>(outer.get(j));
                inner.add(nums[i]);
                outer.add(inner);
            }
        }

        return outer;
    }
    public static List<List<Integer>> subsets(int[] nums) {
        return helper(nums, new ArrayList<>(), new ArrayList<>(), 0);
    }
    public static List<List<Integer>> helper(int[] nums, List<Integer> list, List<List<Integer>> ans, int i) {
        if (i == nums.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }
        list.add(nums[i]);
        helper(nums, list, ans, i + 1 );
        list.remove(list.size() - 1);
        helper(nums, list, ans, i + 1);
        return ans;
    }
}

