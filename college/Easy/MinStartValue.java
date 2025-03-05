package Easy;
public class MinStartValue {
    public static void main(String[] args) {
        int[] nums1 = {-3,2,-3,4,2};
        int[] nums2 = {-1,2};
        int[] nums3 = {1,-2,-3};
        System.out.println(minStartValue(nums1));
        System.out.println(minStartValue(nums2));
        System.out.println(minStartValue(nums3));
    }

    private static int minStartValue(int[] nums) {
        int n = nums.length;
        int min = 1;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
            min = Math.min(min, nums[i]);
        }

        return min < 1 ? (-1) * min + 1 : min;
    }
}
