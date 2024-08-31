package leetcode.easy;

// https://leetcode.com/problems/ugly-number/description/ [SOLVED]

public class UglyNumber {
    public static void main(String[] args){
        System.out.println("is ugly: " + isUgly(14));
    }
    public static boolean isUgly(int n){
        if (n == 0) return false;
        if (n == 1) return true;
        if (n % 2 == 0){
            return isUgly(n / 2);
        }
        if (n % 3 == 0){
            return isUgly(n / 3);
        }
        if (n % 5 == 0){
            return isUgly(n / 5);
        }
        else {
            return false;
        }
    }
}
