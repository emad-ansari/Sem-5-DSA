package striver.pattern;
public class NumberCrownPattern {
    public static void main(String[] args){
        printNumberCrownPattern(5);
    }
    public static void printNumberCrownPattern(int row){
        for (int i = 1; i <= row; i++){
            // print first half part.
            for (int j = 1; j <= i; j++) {
                System.out.print(j );
            }
            // print spaces
            for (int s = 1; s <= 2*(row - i); s++){
                System.out.print(" ");
            }
            // print second half part.
            for(int k = i; k >= 1; k--){
                System.out.print( k );
            }
            System.out.println();
        }
    }
}
