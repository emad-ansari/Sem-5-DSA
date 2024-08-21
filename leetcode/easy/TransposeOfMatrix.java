package leetcode.easy;

// https://leetcode.com/problems/transpose-matrix/description/ [SOLVED]

public class TransposeOfMatrix {
    public static void main(String[] args){
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] transpose = transpose(matrix);
        System.out.println("Transpose of matrix :");
        for(int[] row: transpose){
            for(int col: row){
                System.out.print(col + " ");
            }
            System.out.println();
        }


    }
    public static int[][] transpose(int[][] matrix) {
        if (matrix.length == 1 && matrix[0].length == 1){
            return matrix;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] transpose = new int[col][row];
        for (int i = 0; i < row ; i++){
            for (int j = 0; j < col; j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        return transpose;
    }
}
