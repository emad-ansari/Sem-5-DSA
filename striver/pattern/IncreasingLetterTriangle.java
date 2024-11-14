package striver.pattern;

public class IncreasingLetterTriangle {
    public static void main(String[] args) {
        increasingLetterTriangle(5);
    }
    public static void increasingLetterTriangle(int row){
        for (int i = 1; i <= row; i++){
            int letter = 65;
            for (int j = 1; j <= i; j++){
                System.out.print((char)(letter) + " ");
                letter++;
            }
            System.out.println();
        }
    }
}
