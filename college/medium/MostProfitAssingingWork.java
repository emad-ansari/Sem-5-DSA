package medium;
import java.util.List;

import java.util.ArrayList;
import java.util.Collections;

// https://leetcode.com/problems/most-profit-assigning-work/description/  [SOLVED]
public class MostProfitAssingingWork {
    public static void main(String[] args) {
        int[] difficulty = {2,4,6,8,10};
        int[] worker = {4, 5, 6,7 };
        int[] profit = {10,20,30,40,50};
        
        System.out.println(maxProfitAssignment(difficulty, profit, worker));
        
    }
    public static  int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < difficulty.length; i++) {
            list.add(new int [] {difficulty[i], profit[i]});
        }

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i + 1)[1] = Math.max(list.get(i)[1], list.get(i + 1)[1]);
        }
        
        int maxProfit = 0;
        for (int i = 0; i < worker.length; i++) {
            maxProfit += getMaxForCurrentWorker(list, worker[i]);
        }
        return maxProfit;

    }
    public static int getMaxForCurrentWorker(List<int[]> list, int w) {
        int s = 0, e = list.size() -1 ;
        int currMax = 0;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (list.get(m)[0] <= w) {
                currMax = Math.max(currMax,  list.get(m)[1]);
                s = m + 1;
            }
            else e = m - 1;
        }
        return currMax;
    }    
}
