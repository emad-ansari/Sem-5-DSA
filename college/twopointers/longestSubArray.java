package twopointers;

import java.util.ArrayList;

public class longestSubArray {
    public static void main(String[] args){
        int[] arr = {2, 5, 1, 7, 10};
        System.out.println("Max length: " + lengthOfLongestSubArray(arr, 14));

    }
    public static int lengthOfLongestSubArray(int[] arr, int k){
        int maxLength = 0;
        // generate all Sub arrays

        for (int i = 0; i < arr.length; i++){
            int sum = arr[0];
            for (int j = i + 1; j < arr.length; j++){
                sum = sum + arr[j];
                if (sum > k){
                    break;
                }
                maxLength = Math.max(maxLength, j - i + 1);
            }
        }
        return maxLength;
    }

    // return subarray
    public static ArrayList<Integer> longestSubArray(int[] arr, int k){
        ArrayList<Integer> subarray = new ArrayList<>();
        for (int i = 0; i < arr.length; i++){
            int sum = arr[i];

        }



        return subarray;

    }
}
