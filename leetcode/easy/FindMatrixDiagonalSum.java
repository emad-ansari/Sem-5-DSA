package leetcode.easy;

import java.util.ArrayList;

public class FindMatrixDiagonalSum {
    public static void main(String[] args){
        int[][] mat = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        System.out.println(" ans: " + diagonalSum(mat));
    }
    public static int diagonalSum(int[][] mat) {
        if (mat.length == 1){
            return mat[0][0];
        }
        ArrayList<ArrayList<Integer>> primaryDiagonal = new ArrayList<>();
        ArrayList<ArrayList<Integer>> secondaryDiagonal = new ArrayList<>();
        int pRow = 0;
        int pCol = 0;
        while (pRow < mat.length && pCol < mat.length){
            ArrayList<Integer> point = new ArrayList<>();
            point.add(pRow);
            point.add(pCol);
            primaryDiagonal.add(point);
            pRow++;
            pCol++;
        }
        int sRow = 0;
        int sCol = mat.length -1;
        while (sRow < mat.length  && sCol >= 0) {
            ArrayList<Integer> point = new ArrayList<>();
            point.add(sRow);
            point.add(sCol);
            secondaryDiagonal.add(point);
            sRow++;
            sCol--;
        }
        if (mat.length % 2 != 0){
            secondaryDiagonal.remove(secondaryDiagonal.size() / 2);
        }
        primaryDiagonal.addAll(secondaryDiagonal);
        System.out.println(primaryDiagonal);
        int diagonalSum = 0;
        for (ArrayList<Integer> point: primaryDiagonal) {
            int row = point.get(0);
            int col = point.get(1);
            diagonalSum += mat[row][col];
        }
        return diagonalSum;
    }
}
