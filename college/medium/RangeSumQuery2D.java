package medium;

import java.util.Arrays;
public class RangeSumQuery2D {
    int[][] nums;
    

    public RangeSumQuery2D(int[][] matrix) {
        this.nums = matrix;
        // cal the pref sum
        for (int i = 0; i < nums.length; i++ ) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] += (i != 0 ? nums[i - 1][j] : 0 ) + (j != 0 ? nums[i][j - 1] : 0);
            }
        }

        for (int[] arr: nums) {
            System.out.println(Arrays.toString(arr));
        }
        
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {


        return 0;
        
    
    }

    public static void main(String[] args) {
        int[][] mat = {
            {3, 0, 1, 4, 2},
            {5, 6, 3, 2, 1},
            {1, 2, 0, 1, 5},
            {4, 1, 0, 1, 7},
            {1, 0, 3, 0, 5}
        };
        RangeSumQuery2D obj = new RangeSumQuery2D(mat);
        

    }
    
}
