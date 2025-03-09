package Easy;

// https://leetcode.com/problems/smallest-even-multiple/description/ [SOLVED]

public class SmallestEvenMultiple {
    public static void main(String[] args) {
        System.out.println(" Smallest Even Multiple: " + samllestEvenMultiple(1));
        System.out.println(" Smallest Even Multiple: " + samllestEvenMultiple(2));
        System.out.println(" Smallest Even Multiple: " + samllestEvenMultiple(120));
        System.out.println(" Smallest Even Multiple: " + samllestEvenMultiple(12));
        System.out.println(" Smallest Even Multiple: " + samllestEvenMultiple(150));
        
    }
    public static int samllestEvenMultiple (int n) {
        if (n > 2 && 2 % n == 0) return n;

        for (int i = n; i <= n * 10; i += n) {
            if (i % 2 == 0) return i;
        }
        return -1;
    }
}
