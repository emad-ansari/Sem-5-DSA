import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
        int[] nums = { 1, 7};
        System.out.println(Arrays.toString(findPrefix(nums)));
        System.out.println(Arrays.toString(findSuffix((nums))));
        // System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }

        if (pre[n - 1] - nums[0] == 0 || pre[n - 1] == 0)
            return 0;
        for (int i = 1; i < n - 1; i++) {
            if (pre[i - 1] == pre[n - 1] - pre[i])
                return i;
        }
        return -1;
    }

    public static int[] findPrefix(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
    public static int[] findSuffix(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] += nums[i + 1];
        }
        return nums;
    }

    public static int minStartValue(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] < 1 ? (-1) * nums[0]  + 1 : nums[0];  
        }
        int min = Math.min(1, nums[0]);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i -1];
            min = Math.min(min, nums[i]);
        }
        return min < 1 ? (-1)* min + 1 : min;
    }


}
