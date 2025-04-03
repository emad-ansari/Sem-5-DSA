package Recursion;

public class CountNumberOfZeros {
    public static void main(String[] args) {
        int n = 302040;
        System.out.println(countZeros(n));
    }
    public static int countZeros(int n) {
        return helper(n, 0);
    }
    public static int helper(int n, int cnt) {
        if (n == 0) return cnt;
        if (n % 10 == 0) return helper(n / 10, cnt + 1);
        else return helper(n / 10, cnt);
    }

}
