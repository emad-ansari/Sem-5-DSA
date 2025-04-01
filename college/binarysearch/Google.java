package binarysearch;
import java.util.Scanner;

public class Google {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of trees & Least cutt off in meter: ");
        int n = input.nextInt();
        int M = input.nextInt();
        System.out.print("Enter the trees : ");
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = input.nextInt();
        }
        
        System.out.println("Maximum Height: " + maxIntegerHeight(trees, M));
        input.close();
        
    }
    public static int maxIntegerHeight(int[] trees, int M) {
        int max = trees[0], min = trees[0];
        for (int tree: trees) {
            max = tree > max ? tree : max;
            min = tree < min ? tree : min;
        }
        int s = min, e = max;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (cuttOffSum(trees, m) == M) return m;
            if (cuttOffSum(trees, m) > M) s = m + 1;
            else e = m - 1;
        }
        return e;
    }
    public static int cuttOffSum(int[] trees, int k) {
        int cuttingSum = 0;
        for (int tree: trees) {
            int diff = tree - k;
            cuttingSum += diff > 0 ? diff : 0;
        }
        return cuttingSum;
    }

}