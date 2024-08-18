import java.util.Arrays;

public class FindKthLargestElement {
    public static void main(String[] args){
        int[] arr = {10, 20, 30, 40, 50, 60};
        System.out.println("2nd last element: " + find_kth_largest_element(arr, 3));


    }
    public static int find_kth_largest_element(int[] nums, int kth){
        if (kth >= nums.length){
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - kth];
    }
}
