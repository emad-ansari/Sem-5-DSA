package cses.IncreasingArray;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long cnt = 0, prev = input.nextLong();
        for (int i = 1; i < n; i++) {
            long num = input.nextLong();
            if (num < prev) {
                cnt += prev - num;
            }
            else prev = num;
        }
        System.out.println(cnt);
        input.close();
    }

}