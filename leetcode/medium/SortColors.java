package leetcode.medium;
import java.util.Arrays;

// https://leetcode.com/problems/sort-colors/description/ -[SOLVED]

public class SortColors {
    public static void main(String[] args){
        int[] nums = {2,2};
        sortColors(nums);
        System.out.println("After sorting: " + Arrays.toString(nums));

    }
    public static void sortColors(int[] nums) {
        int[] freq = new int[3];
        for (int item: nums){
            freq[item] += 1;
        }
        int[] ans = new int[nums.length];
        int a = 0;
        int i = 0;
        while (i < ans.length){
            if (freq[a] == 0){
                a++;
            }
            if (freq[a] != 0){
                ans[i] = a;
                freq[a] -= 1;
                i++;
            }
        }
        System.arraycopy(ans, 0, nums, 0, ans.length);
    }
}
