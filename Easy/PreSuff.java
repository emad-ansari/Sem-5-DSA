package Easy;
import java.util.Arrays;

public class PreSuff {
    public static void main(String[] args) {
        int[] nums3 = { 3, 1, 2, 10, 1 };
        preSuff(nums3);
    }

    private static void preSuff(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suff = new int[n];
        pre[0] = nums[0];
        suff[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
            suff[n - 1 - i] += nums[n - 1 - i] + suff[n - i];
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(suff));

    }
}
