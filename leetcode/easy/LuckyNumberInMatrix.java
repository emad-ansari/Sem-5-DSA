package leetcode.easy;
import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/lucky-numbers-in-a-matrix/description/ -[SOLVED]

public class LuckyNumberInMatrix {
    public static void main(String[] args){
        int[][] matrix = {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };
        System.out.println("Lucky Numbers: " + luckyNumbers(matrix));
    }
    public static List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNumber = new ArrayList<>();
        if (matrix.length == 1 && matrix[0].length == 1) {
            luckyNumber.add(matrix[0][1]);
            return luckyNumber;
        }
        for (int i = 0; i < matrix.length; i++){
            int[] row = matrix[i];
            int[] minNumber = findRowWiseMinimumNumber(row);
            int maxNumber = findColWiseMaxNumber(minNumber[1], matrix);
            if (minNumber[0] == maxNumber){
                luckyNumber.add(maxNumber);
            }
        }

        return luckyNumber;
    }

    public static int[] findRowWiseMinimumNumber(int[] arr){
        int minNumber = arr[0];
        int colIndex = 0;
        for(int i = 1; i < arr.length; i++){
            if (arr[i] < minNumber){
                minNumber = arr[i];
                colIndex = i;
            }
        }
        return new int[] {minNumber, colIndex};
    }
    public static int findColWiseMaxNumber(int col, int[][] matrix){
        int maxNumber = matrix[0][col];
        for (int i = 1; i < matrix.length; i++){
            if (matrix[i][col] > maxNumber){
                maxNumber = matrix[i][col];
            }
        }
        return maxNumber;
    }
}
