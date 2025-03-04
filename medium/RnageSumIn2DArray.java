package medium;
public class RnageSumIn2DArray {
    private int[][] nums;

    public RnageSumIn2DArray(int[][] matrix) {
        
        int m = matrix.length, n = matrix[0].length;
        this.nums = new int[m + 1][n + 1];
        for (int r = 1; r <= m + 1; r++) {
            for (int c = 1; c < n + 1; c++) {
                nums[r][c] = matrix[r - 1][c] + matrix[r][c - 1];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        // return nums[]
        return 1;
    }
    public static void main(String[] args) {
        // int[] nums = {
            
        // }
    }
    
}
