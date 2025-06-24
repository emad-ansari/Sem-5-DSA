package cses.BitStrings;
import java.math.BigInteger;
import java.util.Scanner;
public class Main {
    static BigInteger M = BigInteger.valueOf(1_000_000_007);
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n = input.nextInt();
            BigInteger base = BigInteger.valueOf(2);    
            BigInteger mod = BigInteger.valueOf(1_000_000_007);
            BigInteger result = base.modPow(BigInteger.valueOf(n), mod);
            System.out.println(result);
        }
    }
}
