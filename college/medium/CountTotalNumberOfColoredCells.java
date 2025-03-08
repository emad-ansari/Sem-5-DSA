package medium;


// https://leetcode.com/problems/count-total-number-of-colored-cells/  [SOLVED]
public class CountTotalNumberOfColoredCells {
    public static void main(String[] args) {
        int n = 69675;
        System.out.println("Ans: " + coloredCells(n));
    }
    public static long coloredCells(int n) {
        return ((long)(Math.pow(n, 2)) + (long)(Math.pow(n - 1, 2)));
    }

}
