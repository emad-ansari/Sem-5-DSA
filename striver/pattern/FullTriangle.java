package striver.pattern;

public class FullTriangle {
    public static void main(String[] args) {
        printFullTriangle(5);
        printFullTriangleDown(5);
    }
    public static void printFullTriangle(int row ){
        for (int i = 1; i <= row; i++){
            // print void spaces
            for (int j = 1; j <= row -i; j++){
                System.out.print(" ");
            }

            // print stars
            for (int k = 1; k <= (2*i - 1); k++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }
    public static void printFullTriangleDown(int row ){
        for (int i = row ; i >=1 ; i--){
            // print void spaces
            for (int j = 1; j <= row -i; j++){
                System.out.print(" ");
            }

            // print stars
            for (int k = 1; k <= (2*i - 1); k++){
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

}
