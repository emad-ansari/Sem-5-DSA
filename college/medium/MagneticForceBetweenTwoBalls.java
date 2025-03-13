package medium;

import java.util.Arrays;

// https://leetcode.com/problems/magnetic-force-between-two-balls/description/ [SOLVED] 

public class MagneticForceBetweenTwoBalls {
    public static void main(String[] args) {
        int[] position = {1,2,3,4,7};
        int[] position1 = {5,4,3,2,1,1000000000};

        System.out.println(maxDistance(position, 3));
        System.out.println(maxDistance(position1, 2));
        
    }
    public static int maxDistance (int[] position, int b) {
        Arrays.sort(position);
        int s = 1, n = position.length;
        int e = position[n - 1] - position[0];
        while (s <= e) {
            int m= s + (e - s) / 2;
            if (canPlace(position, b, m)) s = m + 1;
            else e = m - 1;
        }
        return e;
    }
    private static boolean canPlace(int[] position, int b, int f) {
        int bc = 1, lastP = position[0];
        for (int i = 1; i < position.length; i++ ) {
            if (position[i] - lastP >= f) {
                lastP = position[i];
                bc++;
                if(bc >= b) return true;
            }
        }
        return false;
    }
}
