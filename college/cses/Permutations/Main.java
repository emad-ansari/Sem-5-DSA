package cses.Permutations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args)throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            if (n > 1 && n <= 3) {
                System.out.println("NO SOLUTION");
                return;
            }
           
            // now generate permutations and check whether beautifull exist or not
            // print even
            for (int i = 2; i <= n; i = i  + 2) System.out.print(i + " ");
            // print odd
            for (int i = 1; i <= n; i = i  + 2) System.out.print(i + " ");
        }
    }

    
}
