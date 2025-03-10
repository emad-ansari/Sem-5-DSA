package medium;


// https://leetcode.com/problems/koko-eating-bananas/description/   [SOLVED]

public class MinEatingSpeed {
    public static void main(String[] args) {
        int[] nums = {30,11,23,4,20};
        
        System.out.println("Ans: " + minEatingSpeed(nums, 6));
        
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = 0;
        for (int pile: piles) e = pile > e ? pile : e;
        while (s <= e) {
            int m = s + (e - s) /2 ;
            long th = 0l; 
            for (int item: piles) th += Math.ceilDiv(item, m);               
            if (th <= h) e = m - 1;
            else if( th > h) s = m + 1;
        }
        return s;
    }
  
}
