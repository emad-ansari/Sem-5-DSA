package cses.Permutations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            if (n > 1 && n <= 3) {
                System.out.println("NO SOLUTION");
                return;
            }
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = i + 1;
            }
            // now generate permutations and check whether beautifull exist or not
            backtrack(nums, new ArrayList<>(), new boolean[] {false});
        }
    }

    private static void backtrack(int[] nums, List<Integer> list, boolean[] find) {
        if (list.size() == nums.length) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            find[0] = true;
            return;
        }
        if (!find[0]) {
            for (int num : nums) {
                if (!list.contains(num)) {
                    if (list.size() > 0) {
                        if (Math.abs(num - list.get(list.size() - 1)) < 2) continue;
                        list.add(num);
                        backtrack(nums, list, find);
                        list.remove(list.size() - 1);
                    }
                    else {
                        list.add(num);
                        backtrack(nums, list, find);
                        list.remove(list.size() - 1);
                    }
                }
            }
        }
        return;
    }
}
