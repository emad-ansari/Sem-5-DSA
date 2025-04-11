package cses.Repetitions;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            String dna = input.nextLine();
            int l = 0, r = 0, lrep = 0;
            while (r < dna.length()) {
                if (dna.charAt(l) == dna.charAt(r)) {
                    lrep = Math.max(lrep, r - l + 1);
                    r++;
                }
                else l = r;
            }
            System.out.print(lrep);
        }
    }
}
