package leetcode.medium;

import java.util.Arrays;

//https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/

// [TODO] : optimize the algorithm

public class RemoveDuplicates {
    public static void main(String[] args){
        int[] arr = {1,1,1,2,2,3};
        System.out.println("Result: " + removeDuplicates(arr));
        System.out.println("Array: " + Arrays.toString(arr));
    }
    public static int removeDuplicates(int[] arr) {
        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (arr[left] == arr[right]) right++;
            else{
                if (right - left > 2 ) {
                    // means that element appears more than two

                    left += 2;
                    while (left < right) {
                        arr[left] = Integer.MAX_VALUE;
                        left++;
                    }
                }
                left = right;
            }
        }
        if (right - left > 2 ) {
            // means that element appears more than two

            left += 2;
            while (left < right) {
                arr[left] = Integer.MAX_VALUE;
                left++;
            }
        }
        Arrays.sort(arr);
        int k = 0;
        for (int num: arr) {
            if (num != Integer.MAX_VALUE) k++;
            else break;
        }
        return k;
    }

}
