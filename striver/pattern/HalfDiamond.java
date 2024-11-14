package striver.pattern;

public class HalfDiamond {
    public static void main(String[] args) {
        halfDiamond(5);
    }
    public static void halfDiamond(int row) {
        for (int i = 1; i <= (2*row - 1); i++){
            int noOfStars = i;
            if (i > row) noOfStars = (2 * row - i);
            for (int j = 1; j <= noOfStars; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
