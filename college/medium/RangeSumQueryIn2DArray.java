package medium;

// https://leetcode.com/problems/range-sum-query-2d-immutable/description/    [SOVLED]
public class RangeSumQueryIn2DArray {

     private int[][] nums;
    private int[][] pref;
    

    public RangeSumQueryIn2DArray(int[][] matrix) {
        this.nums = matrix;
        // calculate the prefix sum;
        int m = nums.length;
        int n = nums[0].length;
        this.pref = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = matrix[i - 1][j - 1] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
            }
        }

    }
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int r1 = row1 + 1;
        int r2 = row2 + 1;
        int c1 = col1 + 1;
        int c2 = col2 + 1;
        
        return pref[r2][c2] - pref[r2][c1 - 1] - pref[r1 - 1][c2] + pref[r1 - 1][c1 - 1];
    }

    public static void main(String[] args) {
        // int[][] mat = {
        //     {3, 0, 1, 4, 2},
        //     {5, 6, 3, 2, 1},
        //     {1, 2, 0, 1, 5},
        //     {4, 1, 0, 1, 7},
        //     {1, 0, 3, 0, 5}
        // };
        // RangeSumQuery2D obj = new RangeSumQuery2D(mat);     

    }
}
