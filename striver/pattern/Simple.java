package striver.pattern;

public class Simple {
    public static void main(String[] args){
        printSimplePattern(5, 4);
    }
    static void printSimplePattern(int row, int col) {
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= col; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
