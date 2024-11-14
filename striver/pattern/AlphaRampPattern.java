package striver.pattern;

public class AlphaRampPattern {
    public static void main(String[] args) {
        alphaRampPattern(5);
    }
    public static void alphaRampPattern(int row) {
        int letter = 65;
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= i; j++){
                System.out.print((char)letter + " ");
            }
            letter++;
            System.out.println();
        }
    }
}
