package Easy;
import java.util.Scanner;

public class ReshapeMatrix {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int m = input.nextInt();
        System.out.print("Enter the number of colums: ");
        int n = input.nextInt();
        int[][] result = new int[m][n];

        System.out.print("Enter the value of r: ");
        int r = input.nextInt();


        // for ()
        int[][] mat = {
            {1, 2},
            {2, 3}
        };
        
        
    }

    private static int[][] matrixReshape(int[][] mat, int r, int c) {
        int[][] result = new int[r][c];
        if (r * c != mat.length * mat[0].length) return mat;
        if (r == mat.length && c == mat[0].length) return mat;
        int row = 0, col = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (col == mat[row].length){
                    row++;
                    col = 0;
                }
                result[i][j] = mat[row][col];
                col++;
            }
        }

        return result;


    }
    
}
