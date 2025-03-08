package Easy;

import java.util.Scanner;

// https://leetcode.com/problems/search-insert-position/description/ [SOLVED]

public class SearchInsertPosition {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements in array: ");
        int n = input.nextInt();
        System.out.print("Enter the target value: ");
        int t = input.nextInt();
        System.out.println();
        int[] nums = new int[n];

        System.out.print("Enter the items: ");
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        
        System.out.println("Result: " + searchInsert(nums, t));
        input.close();
    }
    public static int searchInsert(int[] nums, int target) {
        int s = 0, e = nums.length - 1;
        
        while  ( s <= e) {
            int m = s + (e - s) /2;
            if (nums[m] == target) return m;
            else if (target < nums[m]) e = m - 1;
            else s = m + 1;
        }

        return s;
    }
}
