package Easy;

public class SquareRoot {
    public static void main(String[] args) {
        
    }

    public static int mySqrt(int x) {
        long s = 1, e = x;
        long sqrt = 0;
        while (s <= e) {
            long  m = s + (e - s) / 2;
            if (m * m == x) return (int)m;
            if (m * m > x) e = m - 1;
            else if (m * m < x) {
                sqrt = m;
                s = m + 1;
            }
        }
        return (int)sqrt;
    }
}
