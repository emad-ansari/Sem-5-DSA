package cses.WiredAlgo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n = input.nextLong();
        input.close();
        System.out.print(n + " ");
        while (n != 1) {
            if (n % 2 == 0) {
                n /= 2;
                System.out.print(n + " ");
            }
            else {
                n = (long)n * 3 + 1;
                System.out.print(n + " ");
            }
        }
    }

}
