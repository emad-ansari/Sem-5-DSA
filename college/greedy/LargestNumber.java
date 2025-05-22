package greedy;
import java.util.*;
// https://leetcode.com/problems/largest-number/description/?envType=problem-list-v2&envId=greedy [SOLVED]
public class LargestNumber {
    public static void main(String[] args) {
        int[] nums = {34323,3432};
        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        int n = nums.length;
        String[] arr = new String[n];
        for (int k = 0; k < n; k++) {
            arr[k] = Integer.toString(nums[k]);
        }
        // apply bubble sort
        Comparator<String> comp = new Comparator<>() {
            public int compare(String a, String b) {
                String first = a + b;
                String second = b + a;
                if (second.compareTo(first) > 0) return 1;
                else return -1;
            }
        };
        Arrays.sort(arr, comp);

        StringBuilder sb = new StringBuilder();
        for (String item: arr) {
            sb.append(item);
        }
        String result = sb.toString();
        return result.startsWith("0") ? "0" : result;
    }

}
