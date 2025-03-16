package Easy;
// https://leetcode.com/problems/valid-perfect-square/  [SOLVED]
public class ValidPerfectSquare {
    
    public static boolean isPerfectSquare(int num) {
        if (num == 1) return true;
        int s = 1, e = num / 2;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if ((long)m * m == num ) return true;
            else if ((long)m * m> num) e = m - 1;
            else s = m + 1;
        }
        return false;
    }
}
