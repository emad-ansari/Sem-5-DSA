package leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
// https://leetcode.com/problems/two-sum/description/ -[SOLVED]
public class TwoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println("Ans: " + Arrays.toString(twoSum(arr, 9)));


    }
    public static int[] twoSum(int[] arr, int target){
        if (arr.length == 2 && arr[0] + arr[1] == target){
            return new int[] {0, 1};
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }



        return null;
    }
}
