package medium;

import java.util.Arrays;

// TODO
public class Rotate180Degree {
    public static void main(String[] args) {
        int[][] mat = {
            {10, 8, 3 },
            {5, 20, 6},
            {7, 9, 30}
        };
        rotate(mat);
        for (int[] nums: mat) {
            System.out.println(Arrays.toString(nums));
        }
        
    }
    public static void rotate(int[][] mat) {
        int fr = 0, lr = mat.length - 1;
        while (fr < lr) {
            for (int i = 0; i < mat[0].length; i++) {
                int temp = mat[fr][i];
                mat[fr][i] = mat[lr][i];
                mat[lr][i] = temp;
            }
            fr++;
            lr--;
        }

        for (int i = 0 ;i < mat.length; i++) {
            for (int j = 0; j < mat[0].length / 2; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[i][mat[0].length - j - 1];
                mat[i][mat[0].length - j - 1] = temp;
            }
        }


    }
    
}
