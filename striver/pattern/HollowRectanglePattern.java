package striver.pattern;

public class HollowRectanglePattern {
    public static void main(String[] args) {
        printHollowRectanglePattern(10);
    }
    public static void printHollowRectanglePattern(int N) {
        for( int i = 1; i <= N; i++){
            for (int j = 1; j <= N; j++){
                if (i == 1 || i == N || j == 1 || j == N) {
                    System.out.print("*");
                }
                else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
