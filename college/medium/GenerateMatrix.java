package medium;

import java.util.Arrays;

// https://leetcode.com/problems/spiral-matrix-ii/description/  [SOLVED]
public class GenerateMatrix {
    public static void main(String[] args) {
        int[][] res = generateMatrix(3);
        for (int[] nums: res) {
            System.out.println(Arrays.toString(nums));
        }
    }
    public static int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int fr = 0, lr = n - 1, fc = 0, lc = n - 1, k = 1;

        while (fr <= lr && fc <= lc) {
            // fill first row
            for (int i = fc; i <= lc; i++) {
                res[fr][i] = k++;
            }

            // fill last col
            for (int i = fr + 1; i <= lr; i++) {
                res[i][lc] = k++;
            }

            // fill last row
            if (fr != lr) {
                for (int i = lc - 1; i >= fc; i--) {
                    res[lr][i] = k++;
                }

            }
            // fill first col
            if (fc != lc) {
                for (int i = lr - 1; i > fr; i--) {
                    res[i][fc] = k++;
                }
            }

            fr++;
            lr--;
            fc++;
            lc--;
        }
        return res;
        
    }
}
