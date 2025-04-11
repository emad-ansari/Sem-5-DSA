package cses.TrailingZeros;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)){
            int n = input.nextInt();
            long tz = 0L;
            while (n != 0){
                n /= 5;
                tz += n;
            }
            System.out.println(tz);
        }
    }
}
