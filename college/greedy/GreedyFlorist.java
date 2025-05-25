package greedy;
import java.util.Scanner;
import java.util.Arrays;

public class GreedyFlorist {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int k = input.nextInt();
        int[] c = new int[n];
        for (int i = 0; i < n; i++){
            c[i] = input.nextInt();
        }
        System.out.println(getMinimumCost(k, c));
        input.close();
        
    }
    public static int getMinimumCost(int k, int[] c) {
        int n = c.length, minCost = 0;
        Integer[] nums = new Integer[n];
        for (int l = 0; l < n; l++) {
            nums[l] = c[l];
        }
        Arrays.sort(nums, (a, b) -> b - a);
        
        for (int i = 0; i < n; i++) {
            minCost += nums[i] * (i / k + 1);
        }
        return minCost;
    }
    
}
