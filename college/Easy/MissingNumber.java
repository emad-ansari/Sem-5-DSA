package Easy;

// https://leetcode.com/problems/missing-number/description/  [SOLVED]
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }
    public static int missingNumber(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num: nums) sum += num;

        long d = ((long)n * (n + 1) / 2) - sum;
        return d == 0 ? 0 : (int)d;
    }
}
