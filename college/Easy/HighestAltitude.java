package Easy;
public class HighestAltitude {
    public static void main(String[] args) {
        int[] nums = {-5,1,5,0,-7};
        int[] nums1 = {-4,-3,-2,-1,4,3,2};
        System.out.println(largestAltitude(nums));
        System.out.println(largestAltitude(nums1));
    }

    private static int largestAltitude(int[] nums) {
        int max = Math.max(0, nums[0]);

        for(int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
