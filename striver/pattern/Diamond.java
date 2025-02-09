package striver.pattern;

public class Diamond {
    public static void main(String[] args) {
        printDiamond(5);
    }
    public static void printDiamond(int n ){

        for (int row = 1; row <= n; row++) {
            for (int b = 1; b <= n - row; b++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= 2 * row - 1 ; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int row = n - 1; row >= 1; row--) {
            for (int b = 1; b <= n - row; b++) {
                System.out.print(" ");
            }
            for (int s = 1; s <= 2 * row - 1 ; s++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
