package Recursion;

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/ [SOLVED]
public class NumberOfStepsToMakeReduceNumberToZero {
    public static void main(String[] args) {
        int n = 14;
        System.out.println(numberOfSteps(n));
    }
    public static int numberOfSteps(int num) {
        return helper(num, 0);
    }
    public static int helper(int n, int st) {
        if (n == 0) return st;
        if (n % 2 == 0) return helper(n / 2, st + 1);
        else return helper(n - 1, st + 1);
    }
}
