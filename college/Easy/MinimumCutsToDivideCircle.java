package Easy;

// https://leetcode.com/problems/minimum-cuts-to-divide-a-circle/description/ [SOLVED]

public class MinimumCutsToDivideCircle {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(" Minimum Numbre of Cuts: " + numberOfCuts(n));

    }
    public static int numberOfCuts (int n ) {
        if (n == 1) return 0;
        return n % 2 == 0 ? n / 2 : n;
    }
}
