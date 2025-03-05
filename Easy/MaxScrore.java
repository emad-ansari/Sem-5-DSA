package Easy;

import java.util.Arrays;

public class MaxScrore {
    public static void main(String[] args) {
        String s = "1111";
        System.out.println("Ans: " + maxScore(s));
        
    }
    public static int maxScore(String s) {
        int ones = 0, zeroes = 0, max = 0, n = s.length();
        int[] one = new int[n];
        int[] zero = new int[n];
        char[] c = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (c[i] == '0') zeroes++;
            else if (c[i] == '1') ones++;
            zero[i] = zeroes;
            one[i] = ones;
        }
        // calculate the max score
        System.out.println(Arrays.toString(one));
        System.out.println(Arrays.toString(zero));
        for (int i = 0; i < n; i++) {
            max = Math.max(max, zero[i] + one[n - 1] - one[i]);
        }
        return max;
    }
    
}
