package striver;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class demo {
    public static void main(String[] args) {
        Scanner input = new Scanner (System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] mat  = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = input.nextInt();
            }
        }
        System.out.println(countDistincRows(mat));
        input.close();

    }
    public static int countDistincRows(int[][] mat) {
        Set<String> distinct = new HashSet<>(); 
        
        for (int[] nums: mat) {
            StringBuilder sb = new StringBuilder();
            for(int num: nums) {
               sb.append(num);
            }
            distinct.add(sb.toString());
        }
        return distinct.size();
    }
    
}
