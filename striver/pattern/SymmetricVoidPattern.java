package striver.pattern;

public class SymmetricVoidPattern {
    public static void main(String[] args) {
        printSymmetricVoidPattern(5);
    }
    public static void printSymmetricVoidPattern(int N) {
        int space = 0;
        int stars = N;
        for (int i = 1; i <= 2*N; i++){
            if (i > N) {
                stars++;
                space -= 2;
            }
            // print stars
            for (int j = 1; j <= stars; j++){
                System.out.print("*" );
            }
            // print space
            for (int k = 1; k <= space; k++){
                System.out.print(" ");
            }
            // print stars
            for (int j = 1; j <= stars; j++){
                System.out.print("*");
            }
            if (i <= N) {
                stars--;
                space += 2;
            }
            System.out.println();
        }
    }
}
