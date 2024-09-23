package leetcode.easy;
import java.util.Arrays;
// https://leetcode.com/problems/duplicate-zeros/description/  [Solved]


public class DuplicateZero {
    public static void main(String[] args) {
        int[] arr = { 1,0,2,3,0,4,5,0};
        duplicateZeros(arr);
        System.out.println("After duplicate zero: " + Arrays.toString(arr));
    }
    public static void duplicateZeros(int[] arr) {
        int i = 0;
        while (i < arr.length){
            if (arr[i] == 0){
                shiftElementRight(arr, i);
                i += 2;
            }
            else {
                i++;
            }
        }
    }
    private static void shiftElementRight(int[] arr, int j){
        int k = arr.length -1;
        while(k > j){
            arr[k] = arr[k -1];
            k--;
        }
    }

}

