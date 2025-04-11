package hard;

// https://leetcode.com/problems/first-missing-positive/ [SOLVED]
public class FirstMissingPositive {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(firstMissingPositive(nums));
    }
    public static int firstMissingPositive(int[] nums) {
        int i = 0, n = nums.length;
        while (i < nums.length) {
            if (isInRange(nums[i], n)) {
                int indx = nums[i] - 1;
                if (i != indx) {
                    if (nums[i] == nums[indx]) i++;
                    else swap(nums, i, indx);
                }
                else i++; 
            }
            else i++;
        }
        // now check which number is missing
        for (int j = 0; j < n; j++) {
            if (nums[j] != j + 1) return j + 1;
        }
        return n + 1;
    }
    public static boolean isInRange(int num, int n) {
        return num >= 1 && num <= n; 
    }
    public static void swap(int[] nums, int f, int s) {
        int temp = nums[f];
        nums[f] = nums[s];
        nums[s] = temp;
    }
}
