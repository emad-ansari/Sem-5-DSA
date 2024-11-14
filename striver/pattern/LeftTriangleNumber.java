package striver.pattern;

public class LeftTriangleNumber {
    public static void main(String[] args) {
        printLeftTriangleNumber1(5);
    }
    public static void printLeftTriangleNumber(int row){
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
    public static void printLeftTriangleNumber1(int row){
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

}
