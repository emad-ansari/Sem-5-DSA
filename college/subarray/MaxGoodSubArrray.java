package subarray;
import java.util.Scanner;

import twopointers.longestSubArray;

public class MaxGoodSubArrray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }

        
        input.close();

    }
    
}
