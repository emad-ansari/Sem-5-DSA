package Recursion;

public class PrintPattern {
    public static void main(String[] args) {
        printPattern1(5);
    }
    public static void printPattern(int n) {
        helper(n, 0);
    }
    public static void helper(int r, int c){
        if (r == c) {
            r--;
            c = 0;
            System.out.println();
        }
        if (r == 0) return;
        System.out.print("*" + " ");
        helper(r, c + 1);
    }
    // print lower triangle
    public static void printPattern1(int n) {
        helper1(1, 0, n);
    }
    public static void helper1(int r, int c, int n ) {
        if (r == c) {
            r++;
            c = 0;
            System.out.println();
        }
        if (r > n) return ;
        System.out.print("*" + " ");
        helper1(r, c + 1, n);
    }
}
