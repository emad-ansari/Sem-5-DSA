package leetcode.easy;
import java.util.Arrays;
// https://leetcode.com/problems/convert-1d-array-into-2d-array/?envType=daily-question&envId=2024-09-01  -[SOLVED]


public class Transform1DArrayTo2DArray {
    public static void main(String[] args){
        int[] arr = {1, 2, 3, 4};
        System.out.println("2D Array: " + Arrays.toString(construct2DArray(arr, 2, 2)));

    }
    public static int[][] construct2DArray(int[] original, int m, int n) {
        int[][] matrix = new int[m][n];

        if ((m * n) != original.length){
            return new int[][]{};
        }

        int row = 0;
        int col = 0;
        for (int i = 0; i < original.length; i++){
            if (i != 0 && i % n == 0){
                row++;
                col = 0;
            }
            matrix[row][col] = original[i];
            col++;
        }
        return matrix;
    }
}
