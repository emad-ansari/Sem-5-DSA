package cses.FactoryMachines;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner input = new Scanner (System.in)) {
            int n = input.nextInt();
            int t = input.nextInt();
            int[] nums = new int[n];
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;

            for (int i = 0; i < n; i++) {
                int num = input.nextInt();
                max = Math.max(max, num);
                min = Math.min(min, num);
                nums[i] = num;
            }
            long s = min, e = (long)max * t;

            while (s <= e ) {
                long m = s + (e - s) / 2;
                if (isPossible(nums, m, t))  e = m - 1;
                else s = m + 1;
            }
            System.out.print(s);
        }
    }
    public static boolean isPossible(int[] nums, long m, int t) {
        long tp = 0L;
        for (int i = 0; i < nums.length; i++) {
            tp += m / nums[i];
            if (tp >= t) return true;
        }
        return false;
    }
}
