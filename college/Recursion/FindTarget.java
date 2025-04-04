package Recursion;

import java.util.ArrayList;
import java.util.List;

public class FindTarget {
    public static void main(String[] args) {
        int[] nums = {4, 2, 3, 4, 4, 8};
        System.out.println(findTarget(nums, 4));
    }
    public static List<Integer> findTarget(int[] nums, int t) {
        return search(nums, t, 0);
    }
    public static List<Integer> search(int[] nums, int t, int i) {
        if (i == nums.length) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (nums[i] == t) list.add(i);
        List<Integer> ans = search(nums, t, i + 1);
        list.addAll(ans);
        return list;
    }
}
