package striver.pattern;

public record Waseem01Pattern() {
    public static void main(String[] args ) {
        printPattern(5);
    }
    public static void printPattern (int n) {
        int stars = n;
        int spaces = n + 1;
        for (int row = 0; row < n; row++) {
            if (row < n/2) {
                System.out.print("*");
                for (int b = 1; b <= 3 * n; b++) {
                    System.out.print(" ");
                }
                System.out.print("*");
            }
            else {
                if (row == n / 2) {
                    System.out.print("*");
                    for (int e = 1; e <= n; e++) {
                        System.out.print("e");
                    }
                    for (int s = 1; s <= stars; s++) {
                        System.out.print("*");
                    }
                    for (int e = 1; e <= n; e++) {
                        System.out.print("e");
                    }
                    System.out.print("*");

                }
                else {
                    System.out.print("*");
                    for (int b = 1; b <= spaces; b++) {
                        System.out.print(" ");
                    }

                    for (int s = 1; s <= stars; s++) {
                        System.out.print("*");
                    }

                    for (int b = 1; b <= spaces; b++) {
                        System.out.print(" ");
                    }
                    System.out.print("*");
                    spaces++;
                }
                stars = stars - 2;
            }
            System.out.println();
        }
    }
}
