package Easy;


// https://leetcode.com/problems/arranging-coins/description/  [SOLVED]
public class ArrangingCoins {
    public static void main(String[] args) {
        // int m = 4;
        // float a = (float)(m + 1) / 2;
        // float  a= (float) 5/2;
        // System.out.println(a);

        System.out.println(arrangeCoins(8));
        System.out.println(arrangeCoins(100000));
        System.out.println(arrangeCoins(1804289383));
        
    }
    public static int arrangeCoins(int n) {
        int s = 1, e = n;
        while (s <= e) {
            int m = s + (e - s) / 2;
            double sum = m * (double)(m + 1) / 2;
            if (sum <= n) s = m + 1;
            else e = m - 1;
        }
        return e;
    }
}
