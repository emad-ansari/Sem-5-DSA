package striver.pattern;

public class AlphaHillPattern {
    public static void main(String[] args) {
        alphaHillPattern(5);
    }
    public static void alphaHillPattern(int n) {
        for (int i = 1; i <= n; i++){
            // print space
            for (int s = 1; s <= (n - i); s++){
                System.out.print(" ");
            }
            // print letter
            int letter = 64;
            for(int l = 1; l <= 2*i -1; l++){
                if (l > i) letter--;
                else letter++;
                System.out.print((char)letter + " ");
            }
            System.out.println();
        }
    }
}
