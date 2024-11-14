package striver.pattern;

public class IncreasingNumberTriangle {
    public static void main(String[] args) {
        increasingNumberTriangle(5);
    }
    public static void  increasingNumberTriangle(int row) {
        int num = 1;
        for (int i = 1; i <= row; i++){
            for (int j = 1; j <= i; j++){
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
