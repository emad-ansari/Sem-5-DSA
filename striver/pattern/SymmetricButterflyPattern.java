package striver.pattern;

public class SymmetricButterflyPattern {
    public static void main(String[] args) {
        printSymmetricButterflyPattern(6);
    }
    public static void printSymmetricButterflyPattern(int N) {
        for (int i = 1; i <= (2*N - 1); i++){
            int stars = i;
            if (i > N) {
                stars = 2 * N - i;
            }
            //print first half
            for (int j = 1; j <= stars; j++){
                System.out.print("*");
            }
            // print spaces
            for (int k = 1; k <= 2 * Math.abs(N - i); k++){
                System.out.print(" ");
            }
            //print second half
            for (int j = 1; j <= stars; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
