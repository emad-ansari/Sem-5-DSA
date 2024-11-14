package striver.pattern;

public class AlphaTrianglePattern {
    public static void main(String[] args) {
        alphaTrianglePattern(6);
    }
    public static void alphaTrianglePattern(int n) {
        for (int i = 1; i <= n; i++){
            int letter = 65 + n -i;
            for (int j = 1; j <= i; j++){
                System.out.print((char)letter + " ");
                letter++;
            }
            System.out.println();
        }
    }
}
