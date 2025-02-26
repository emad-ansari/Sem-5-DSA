package leetcode.medium;

import java.util.HashMap;
// [SOLVED]: https://leetcode.com/problems/fruit-into-baskets/description/
// [TODO]: OPTIMIZE IT
public class FruitIntoBasket {
    public static void main(String[] args) {
        int[] fruits = {3,3,3,1,2,1,1,2,3,3,4};
        System.out.println("Ans: " + totalFruit(fruits));
    }
    public static int totalFruit(int[] fruits) {
        int l = 0;
        int r = 0;
        int maxPick = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);
            if (map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);
                if (map.get(fruits[l]) == 0) map.remove(fruits[l]);
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
