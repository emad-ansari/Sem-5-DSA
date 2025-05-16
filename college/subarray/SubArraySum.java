package subarray;

public class SubArraySum {
    public static void main(String[] args) {
        int[] nums = {-2, -3, 4, -1, -2, 1, 5, -3 };
        System.out.println(maxSubarraySum(nums));
        printMaxSubarray(nums);
    }
    public static int maxSubarraySum(int[] nums) {
        int n = nums.length, sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) sum = 0;
        }
        return max < 0 ? 0 : max;
    }

    // print the Max sub array
    public static void printMaxSubarray(int[] nums) {
        int n = nums.length, sum = 0, max = Integer.MIN_VALUE, start = 0, l = -1, r = -1;
        for (int i = 0; i < n; i++) {
            if (sum == 0) start = i;
            sum += nums[i];
            if (sum >= max) {
                l = start;
                r = i;
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        // run the loop from l to r and print the number
        System.out.print("[");
        for (int i = l; i <= r; i++) {
            if (i == r) System.out.println(nums[i] + "]");
            else System.out.print(nums[i] + ", ");
        }
    }
    
}
