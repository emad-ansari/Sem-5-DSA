package medium;
import java.util.Arrays;

public class GetSumAbsoluteDiff {
    public static void main(String[] args) {
        int[] nums = {1,4,6,8,10};
        System.out.println("Result: " + Arrays.toString(getSumAbsoluteDifferences1(nums)));
        
    }
    // Brute force approach
    public static int[] getSumAbsoluteDifferences(int[] nums) {
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum += Math.abs(nums[i] - nums[j]);
            }
            result[i] = sum;
        }
        return result;
        
    }
    public static int[] getSumAbsoluteDifferences1(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] pref = new int[n];
        int[] suff = new int[n];
        pref[0] = nums[0];
        suff[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + nums[i];
            suff[n - i - 1] = suff[n - i] + nums[n - i - 1];
        }

        for (int i = 0; i < n ; i++) {
            if (i == 0) {
                result[i] = Math.abs(suff[i + 1] - (n - i  - 1) * nums[i]);
            }
            else if (i == n - 1) {
                result[i] = Math.abs(pref[i - 1] - i * nums[i]);
            }
            else {
                result[i] = Math.abs(pref[i - 1] - (i) * nums[i]) + Math.abs(suff[i + 1] - (n - i - 1) * nums[i]);
            }
        } 
        return result;    
    }
    
}
