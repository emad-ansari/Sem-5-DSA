package medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/set-matrix-zeroes/ [SOLVED] 


public class SetMatrixZero {
    public static void main(String[] args) {
        
    }
    public static void setZeroes(int[][] mat) {
        List<List<Integer>> zeros = new ArrayList<>();

        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    zeros.add(list);
                }
            }
            
        }

        // now mark the entire row and column as zero where you encounter zero.

        for (int i = 0; i < zeros.size(); i++) {
            int row = zeros.get(i).get(0);
            int col = zeros.get(i).get(1);
            // mark the entire row as zero
            for (int c = 0; c < mat[row].length; c++) {
                mat[row][c] = 0;
            }

            // mark entire column as zero
            for (int r = 0; r < mat.length; r++) {
                mat[r][col] = 0;
            }
        }
    }
    
    public static void setZeros2(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        boolean[][] updatedZero= new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0 && !updatedZero[i][j]) {
                    // now you need to make the entire row and column as zero 
                    
                    for (int c = 0; c < n; c++) {
                        mat[i][c] = 0;
                        updatedZero[i][c] = true;
                    }
        
                    // mark entire column as zero
                    for (int r = 0; r < m; r++) {
                        mat[r][j] = 0;
                        updatedZero[r][j] = true;
                    }
                }
            }
        }

    }
}
