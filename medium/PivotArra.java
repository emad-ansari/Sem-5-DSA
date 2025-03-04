package medium;
import java.util.Arrays;

public class PivotArra {
    public static void main(String[] args) {
        int[] nums = {9, 12, 5, 10, 14, 3, 10};
        System.out.println(Arrays.toString(piivotArray(nums, 10)));

        
    }
    public static int[] piivotArray(int[] nums, int p) {
        int g = 0;
        
        for (int item: nums) {
            if (item  > p) g++;
        }
        int s = 0, m = 0, h = nums.length -g;
        int a = nums.length - 1;
        while (m <=  a) {
            if (nums[m] < p) {
                swap(nums, s, m);
                s++;
                m++;
            }
            else if(nums[m] == p) {
                m++;
            }
            else {
                swap(nums, m, h);
                h++;
                a--;
            }
        }
        return nums;


    }
    public static void swap(int[] nums, int first , int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }

    
}
