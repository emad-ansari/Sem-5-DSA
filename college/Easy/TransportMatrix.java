package Easy;

public class TransportMatrix {
    public static void main(String[] args) {

        
    }
    private int[][] transpose(int[][] mat) {
        int r = mat.length, c = mat[0].length;
        int[][] result = new int[c][r];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[j][i] = mat[i][j];
            }
        }
        return result;

    }
    
}
