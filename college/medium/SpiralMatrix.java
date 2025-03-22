package medium;

import java.util.ArrayList;
import java.util.List;
// https://leetcode.com/problems/spiral-matrix/  [SOLVED]
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println(spiralOrder(mat));

    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> spiral = new ArrayList<>();

        int frow = 0, lrow = matrix.length - 1, fcol = 0, lcol = matrix[0].length - 1;
        while (frow <= lrow && fcol <= lcol) {
            // first row
            for (int i = fcol; i <= lcol; i++) {
                spiral.add(matrix[frow][i]);
            }
            // last column

            for (int i = frow + 1; i <= lrow; i++) {
                spiral.add(matrix[i][lcol]);
            }
            // last row
            if (frow != lrow) {
                for (int i = lcol - 1; i >= fcol; i--) {
                    spiral.add(matrix[lrow][i]);
                }
            }

            // first col
            if (fcol != lcol) {
                for (int i = lrow - 1; i > frow; i--) {
                    spiral.add(matrix[i][fcol]);
                }
            }

            frow++;
            lcol--;
            lrow--;
            fcol++;
        }
        return spiral;

    }

    
}
