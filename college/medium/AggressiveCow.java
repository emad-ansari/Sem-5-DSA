package medium;
import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/aggressive-cows/1?itm_source=geeksforgeeks&itm_medium=article&itm_campaign=practice_card   [SOVLED]
public class AggressiveCow {

    public static void main(String[] args) {
        int[] stalls = {1, 2, 4, 8, 9};
        int[] stalls1 = {10, 1, 2, 7, 5};
        int[] stalls2 = {2, 12, 11, 3, 26, 7};
        int[] stalls3 = {18, 2, 7};

        System.out.println(aggressiveCow1(stalls, 3));
        System.out.println(aggressiveCow1(stalls1, 3));
        System.out.println(aggressiveCow1(stalls2, 5));
        System.out.println(aggressiveCow1(stalls3, 3));
        
    }
    // Brute force Approach.
    public static int aggressiveCow(int[] stalls, int k) {
        
        int mx = 0, n = stalls.length;

        Arrays.sort(stalls);

        int e = stalls[n - 1] - stalls[0];
        for (int i = 1; i <= e; i++) {
            if (canPlace (stalls, k, i)) {
                mx = i;
            }
        }
        return mx;
        
    }
    public static boolean canPlace(int[] stalls, int k, int d) {
        int cntc = 1, lastCP = stalls[0];

        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - lastCP >= d) {
                lastCP = stalls[i];
                cntc++;
                if (cntc >=  k) return true;
            }
        }

        return false;
    }

    // Optimized Approach
    public static int aggressiveCow1(int[] stalls, int k) {
        Arrays.sort(stalls);
        int s = 1, n = stalls.length;
        int e = stalls[n - 1] - stalls[0];
        int max = 0;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (canPlace(stalls, k, m)) {
                max = Math.max(max, m);
                s = m + 1;
            }
            else e = m -1;
        }
        return max;
    }
}
