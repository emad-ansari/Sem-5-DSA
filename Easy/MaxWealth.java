package Easy;
import java.util.ArrayList;
import java.util.Scanner;

// https://leetcode.com/problems/richest-customer-wealth/description/ [SOLVED]

public class MaxWealth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("How many number of rows you want: " );
        int m = input.nextInt();
        System.out.print("How many number of columns you want: " );
        int n = input.nextInt();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        System.out.print("Enter the input nubmers: ");
        for (int i = 0; i < m; i++){
            System.out.println("Enter the input for " + i + "th row" );
            ArrayList<Integer> inner = new ArrayList<>();
            for (int j = 0; j < n; j++){
                int num = input.nextInt();
                inner.add(num);
            }
            list.add(inner);
        }

        System.out.println(maxWealth(list));

        input.close();
    }

    private static int maxWealth(ArrayList<ArrayList<Integer>> nums) {
        int max = 0;
        for (ArrayList<Integer> arr : nums) {
            int sum = 0;
            for (int num: arr) {
                sum += num;
            }
            max = Math.max(max, sum);
        }
        return max;
    }
}
