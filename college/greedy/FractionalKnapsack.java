package greedy;

import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.List;
// https://www.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1  [SOLVED]
public class FractionalKnapsack {
    public static void main(String[] args) {
        // int[] values = {60, 100, 120};
        // int[] weights = {10, 20, 30};
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int C = input.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++)
            values[i] = input.nextInt();
        for (int i = 0; i < n; i++)
            weights[i] = input.nextInt();
        System.out.println(fractionalKnapsack(values, weights, C));
        input.close();

    }

    static class Item {
        int val;
        int wt;

        Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
    }

    public static double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here.
        int n = values.length;
        List<Item> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            items.add(new Item(values[i], weights[i]));
        }

        // sort according to profit/wt ratio.
        Comparator<Item> comp = new Comparator<>() {
            public  int compare(Item a, Item b) {
                double first = (double)b.val/b.wt;
                double second = (double)a.val/a.wt;
                if (first > second) return 1;
                if (first == second) return 0;
                else return -1;
            }
        };
        Collections.sort(items, comp);

        double maxProfit = 0.0;
        for (int i = 0; i < n; i++) {
            Item currItem = items.get(i);
            if (currItem.wt <= W) {
                // take the complete item;
                maxProfit += currItem.val;
                W -= currItem.wt;
            } else {
                maxProfit += ((double) currItem.val / currItem.wt) * W;
                W = 0;
                break;
            }
        }
        return maxProfit;
    }

}
