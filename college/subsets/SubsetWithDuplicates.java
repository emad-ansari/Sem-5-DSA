package subsets;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/  [SOLVED]
public class SubsetWithDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
        
    }
    public static List<List<Integer>> subsetsWithDup(int[] nums) {     
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int e = 0;
        for (int i = 0; i < nums.length; i++) {
            int s = 0;
            if (i > 0 && nums[i] == nums[i - 1]) s = e + 1;
            e = outer.size() - 1;
            int n = outer.size();
            for (int j = s; j < n; j++) {
                List<Integer> list = new ArrayList<>(outer.get(j));
                list.add(nums[i]);
                outer.add(list);
            }
        }
        return outer;
    }
}
