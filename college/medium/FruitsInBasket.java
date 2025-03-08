package medium;
import java.util.HashMap;

//  https://leetcode.com/problems/fruit-into-baskets/description/  [SOLVED]

public class FruitsInBasket {
    public static void main(String[] args) {

        // int[] nums = { 1, 2, 2, 2, 3, 3, 2, 2 };
        // int[] nums1 = { 3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4 };
        int[] fruits = { 6, 2, 1, 1, 3, 6, 6 };
        //
        // System.out.println("Ans: " + totalFruits(nums));
        System.out.println("Ans: " + totalFruits(fruits));

    }

    public static int totalFruits(int[] fruits) {
        int l = 0, r = 0;
        int maxPick = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            if (map.size() > 2) {
                // it means that i put three type of item in bag which is not possible
                // so remove item from bag until it contain exactly two types fruits
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0)  map.remove(fruits[l]);
                l++;
            }
            else if (map.size() <= 2) {
                maxPick = Math.max(maxPick, r - l + 1);
            }
            r++;
        }
        
        return maxPick;
    }

}
