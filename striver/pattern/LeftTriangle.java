package striver.pattern;

public class LeftTriangle {
    public static void main(String[] args){
        printLeftTriangleDown(5);

    }
    public static void printLeftTriangle(int row) {
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= i; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
    public static void printLeftTriangleDown(int row) {
        for (int i = row; i >= 1; i--){
            for (int j = 1; j <= i; j++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
}
