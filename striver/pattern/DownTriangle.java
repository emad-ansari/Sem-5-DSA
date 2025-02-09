package striver.pattern;

public class DownTriangle {
    public static void main (String[] args) {
        printDownTriangle(6);
    }
    public static void printDownTriangle(int n) {
        int spaces = 0;

        for (int row = n; row >= 1; row = row - 2) {
            for (int b = 1; b <= spaces; b++) {
                System.out.print(" ");
            }

            for (int s = 1; s <= row; s++) {
                System.out.print("*");
            }
            spaces++;
            System.out.println();
        }
    }
}
