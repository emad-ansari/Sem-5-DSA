package medium;

import java.util.Arrays;

// https://leetcode.com/problems/matrix-block-sum/

public class MatrixBlockSum {
    
    public static int[][] matrixBlockSum(int[][] mat, int k) {
        // claculate the prefix sum of mat
        int m = mat.length, n = mat[0].length;

        int[][] pref = new int[m + 1][n + 1];
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }
        
        // now iterate over the answer matrix
        int[][] answer = new int [m][n];

        for (int i = 0;  i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = i - k < 0 ? 0 : i - k;
                int r2 = i + k >= mat.length ? mat.length - 1 : i + k;
                int c1 = j - k < 0 ? 0 : j - k;
                int c2 = j + k >= mat[0].length ? mat[0].length - 1 : j + k;

                r1 += 1;
                c1 += 1; 
                r2 += 1;
                c2 += 1;

                answer[i][j] = pref[r2][c2] - pref[r2][c1 - 1] - pref[r1 - 1][c2] + pref[r1 - 1][c1 - 1];   
            }
        }  
        return answer;

    }
   

    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] ans = matrixBlockSum(mat, 1);
        for (int t = 0; t < ans.length; t++) {
            System.out.println(Arrays.toString(ans[t]));
        }

    }
   

}
