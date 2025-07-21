package math;

public class Gcd {

    /* 
        GCD: Greatest Common divisor
        Time Complexity: O(log(min(a, b)))
     */
    public static void main(String[] args) {
        int a = 10, b = 20;
        System.out.println(gcd(a, b));
    }
    public static int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
    
}
