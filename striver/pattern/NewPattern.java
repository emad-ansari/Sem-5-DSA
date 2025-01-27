package striver.pattern;

public class NewPattern {
    public static void main (String[] args ){
        printPattern(4);
    }

    public static void printPattern(int n) {
        int row = n*3;
        int col = n*n - n + 3;
        int stars = 1;
        int spaces = n;
        boolean isEnterMiddle = false;
        for (int i = 1; i <= row; i++){

            for (int j = 1; j <= col; j++) {
                // print @
                if (i <= n + 1 && j == 1) {
                    System.out.print("@");
                    if (i <= n ) {
                        break;
                    }
                }
                // print *
                else if (i >= (n + 1) && i <= (2 * n) && j != col) {
                    // print space
                    if (i == (n + 1 ) && stars < n + 1) {
                        System.out.print("*");
                        stars++;
                        if (stars > n) break;
                    }
                    else {
                        // means i > n + 1
                        if (j <= spaces) {
                            System.out.print(" ");
                        }
                        if (j > spaces && stars < n +1) {
                            System.out.print("*");
                            stars++;
                        }
                        isEnterMiddle = true;

                    }
                }
                else if (i >= 2 * n && j == col) {
                    System.out.print("@");
                }
                else {
                    System.out.print(" ");
                }
            }
            stars = 1;
            if (isEnterMiddle) {
                spaces = spaces + (n - 1);
            }
            System.out.println();
        }
    }
}
