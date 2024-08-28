package leetcode.medium;
import java.util.Arrays;

public class kthLargestElement {
    public static void main(String[] args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        System.out.println("kth largest element: " + findKthLargest(nums, 4));

    }
    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 1 && k == 1){
            return nums[0];
        }
        Arrays.sort(nums);
        return nums[nums.length -k];

    }
}
