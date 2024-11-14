package striver.pattern;

public class BinaryNumberTriangle {
    public static void main(String[] args) {
        binaryNumberTriangle(5);
    }
    public static void binaryNumberTriangle(int row){
        for (int i = 1; i <= row; i++){
            int binaryNum = i % 2 == 0 ? 0 : 1;
            for (int j = 1; j <= i; j++){
                System.out.print(binaryNum + " ");
                binaryNum = binaryNum == 0 ? 1 : 0;
            }
            System.out.println();
        }
    }
}
