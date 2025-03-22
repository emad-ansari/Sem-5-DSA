package medium;

public class SearchIn2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        System.out.println(searchMatrix2(matrix, 3));
        System.out.println(searchMatrix2(matrix, 13));
        System.out.println(searchMatrix2(matrix, 30));
        System.out.println(searchMatrix2(matrix, 12));
        System.out.println(searchMatrix2(matrix, 6));
        
    }
    // O(m + n)  search in 2d matrix II
    public static boolean searchMatrix(int[][] mat, int t) {
        int rs = 0, ce = mat[0].length - 1;
        while (rs <  mat.length &&  ce >= 0) {
            if (mat[rs][ce] == t) return true;
            else if (t > mat[rs][ce]) rs++;
            else ce--;
        }
        return false;
    }

    // optimized search O(log(m * n)); (search in 2d matrix)
    public static boolean searchMatrix2(int[][] mat, int t) {
        int rs = 0, re = mat.length, ce = mat[0].length - 1,  cm = ce / 2;
        if (re - rs + 1 == 1) return binarySearch(mat, rs, 0, mat[0].length - 1, t);
        while (rs < re - 1) {
            int rm = rs + (re - rs) / 2;
            if (mat[rm][cm] == t) return true;
            if (t > mat[rm][cm]) rs = rm;
            else re = rm;
        }
        // now when while loop will break, there will be only two rows remaining, and we can apply binary search on it
        // so we have four part to search right now.

        if (mat[rs][cm] == t) return true;
        if (mat[rs + 1][cm] == t) return true;

        // first part
        if (t < mat[rs][cm]) return binarySearch(mat, rs, 0, cm - 1, t);

        // second part
        if (t > mat[rs][cm] && t <= mat[rs][ce]) return binarySearch(mat, rs, cm + 1, ce, t);

        // third part
        if (t < mat[rs + 1][cm]) return binarySearch(mat, rs + 1, 0, cm - 1, t);

        // fourth part
        return binarySearch(mat, rs + 1, cm + 1, ce, t);
    }
    public static boolean binarySearch(int[][] mat, int r, int cs, int ce, int t) {
        while (cs <= ce) {
            int cm = cs + (ce - cs) / 2;
            if (mat[r][cm] == t) return true;
            else if (t > mat[r][cm]) cs = cm + 1;
            else ce = cm - 1;
        }
        return false;
    }
}
