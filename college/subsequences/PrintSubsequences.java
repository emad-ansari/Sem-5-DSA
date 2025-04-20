package subsequences;
import java.util.List;
import java.util.ArrayList;

public class PrintSubsequences {
    public static void main(String[] args) {
        int[] nums = {4,2,5,3};
        printSubsequences(nums, 0, new ArrayList<>());
        
    }
    public static void printSubsequences(int[] nums, int i, List<Integer> list) {
        if (i >= nums.length) {
            System.out.println(list);
            return;
        }
        list.add(nums[i]);
        printSubsequences(nums, i + 1, list);
        list.removeLast();
        printSubsequences(nums, i + 1, list);
    }
}
