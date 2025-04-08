package cses.MissingNumber;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int n = input.nextInt();
        long sum = 0L;
        long pcs = (long) n * (n + 1) / 2;
        for (int i = 0; i < n - 1; i++) {
            sum +=  input.nextInt();
        }
        System.out.print(pcs - sum);
        input.close();
    }
    
}
