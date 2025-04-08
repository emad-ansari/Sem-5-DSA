package cses.NumberSpiral;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int t = Integer.parseInt(br.readLine());
            for (int i = 0; i < t; i++) {
                String[] inputs = br.readLine().split(" ");
                long y = Long.parseLong(inputs[0]);
                long x = Long.parseLong(inputs[1]);
                // Case:- 1
                if (y > x) {
                    if (y % 2 == 0) {
                        System.out.print(y * y - (x - 1));
                    } else
                        System.out.print((y - 1) * (y - 1) + x);
                } else if (x > y) {
                    if (x % 2 == 0) {
                        System.out.print((x - 1) * (x - 1) + y);
                    } else
                        System.out.print(x * x - (y - 1));
                } else {
                    // x == y
                    if (y % 2 == 0) {
                        System.out.print(y * y - (x - 1));
                    } else
                        System.out.print((y - 1) * (y - 1) + x);
                }
                System.out.println();
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
