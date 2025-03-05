package Easy;

import java.util.Arrays;
import java.util.Scanner;

// https://leetcode.com/problems/convert-1d-array-into-2d-array/ [SOLVED]
public class OneDArrayToTwoDArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        
        System.out.print("Enter the number of row in matrix: ");
        int m = input.nextInt();

        System.out.print("Enter the number of colum in matrix: ");
        int n = input.nextInt();

        int[] nums = new int[m*n];
        System.out.print("Enter the item of array: ");

        for (int i = 0; i < nums.length; i++) {
            nums[i] = input.nextInt();
        }
        System.out.println("2D Array: ");
        int[][] matrix = construct2DArray(nums, m , n);

        for(int[] row: matrix) {
            System.out.println(Arrays.toString(row));
        }
        input.close();
    }
    private static int[][] construct2DArray(int[] nums, int m , int n) {
        int[][] result = new int[m][n];
        if (m * n != nums.length) return new int[][]{};
        int row = 0, col = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && i % n == 0) {
                row++;
                col = 0;
            }
            result[row][col] = nums[i];
            col++;
        }
        return result;
    }
    
}