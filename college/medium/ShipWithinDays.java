package medium;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/ [SOLVED]
public class ShipWithinDays {
    public static void main(String[] args) {
        int[] weights = {1,2,3,4,5,6,7,8,9,10};
        int[] weights1 = {3,2,2,4,1,4};
        int[] nums = {1,2,3,1,1};


        System.out.println("Ans: " + shipWithinDays(weights, 5));
        System.out.println("Ans: " + shipWithinDays(nums, 4));
        System.out.println("Ans: " + shipWithinDays(weights1, 3));

        
    }
    public static  int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for (int item: weights) sum += item;
        int max = 0;
        for (int item: weights) {
            if (item > max) max = item;
        } 

        int s = max, e = sum;
        int leastCap = 0; 
        while (s < e) {
            int m = s + (e - s) / 2;
            int calculatedDays = calDays(weights, m);
            if (calculatedDays <= days) {
                leastCap = m;
                e = m - 1;
            } 
            else if (calculatedDays > days) s = m + 1;
        }
        return leastCap;
        
    }
    public static int calDays(int[] weights, int c) {
        int load = 0;
        int days = 1;
        for (int i = 0; i < weights.length; i++) {
            if (load + weights[i] > c) {
                days++;
                load = weights[i];
            }
            else load += weights[i];
        }   
        
        return days;
    }

    public static int shipWithinDays2 (int[] weights, int days) {
        int s = 1, e = 0;
        for (int weight: weights) e += weight;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (canShipForCap(weights, days, m)) e = m - 1;
            else s = m + 1; 
        }
        return  s;
    }
    public static boolean canShipForCap(int[] weight, int days, int cp) {
        int load = 0;
        int requiredDays = 1;

        for (int i = 0; i < weight.length; i++){
            load += weight[i];
            if (cp < weight[i]) return false;
            if (load > cp) {
                load = weight[i];
                requiredDays++;
                if (requiredDays > days) return false;
            }
        }
        return true;
    }
}
