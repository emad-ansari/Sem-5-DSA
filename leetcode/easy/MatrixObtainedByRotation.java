package leetcode.easy;

import java.util.Arrays;
// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/ -[SOLVED]

public class MatrixObtainedByRotation {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {0,1},
                {1,1},
        };
        int[][] target = {
                {1, 0},
                {0,1},
        };
        System.out.println("Ans: " + rotationCount(matrix1, target));


    }

    public static boolean rotationCount(int[][] matrix, int[][] target){
        for (int i = 0; i < 4; i++) {
            findTranspose(matrix); // find the transpose of matrix;

            for (int[] row: matrix) {
                reverseOrder(row);
            }
            // finally matrix has been rotated 90 degree
            // check whether they are equal are not
            if (isEqual(matrix, target)){
                return true;
            }
        }

        return false;
    }

    public static boolean isEqual(int[][] matrix1, int[][] matrix2) {

        for (int i = 0; i < matrix1.length; i++){
            if (!Arrays.equals(matrix1[i], matrix2[i])){
                return false;
            }
        }
        return true;
    }
    public static void reverseOrder(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e){
            int temp = arr[s];
            arr[s] = arr[e];
            arr[e] = temp;
            s++;
            e--;
        }
    }
    public static void findTranspose(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                if (row < col) {
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }
    }
    public static void displayMatrix(int[][] matrix) {
        for (int[] row: matrix){
            for(int item: row) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
