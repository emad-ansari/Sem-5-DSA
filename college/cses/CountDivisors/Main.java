package cses.CountDivisors;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// solved

public class Main {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br  = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            while (n != 0) {
                int x = Integer.parseInt(br.readLine());
                int fact = 1;
                for (int i = 2; i * i <= x; i++) {
                    // how to check whether the number is prime or not -> if number is prime then find the count 
                    int cnt = 0;
                    if (x % i == 0 ) {
                        while (x % i == 0) {
                            cnt++;
                            x /= i;
                        }
                        fact *= (cnt + 1);
                    }
                }
                if (x != 1) {
                    fact *= 2;
                    System.out.println(fact);
                }
                else System.out.println(fact);
                n--;
                
            }
        }
    }
}
