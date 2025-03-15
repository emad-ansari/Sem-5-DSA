package Easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


// https://leetcode.com/problems/the-k-weakest-rows-in-a-matrix/  [SOLVED]
public class KWeakestRowInMatrix {
    public static void main(String[] args) {
        

        
    }
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] res = new int[k];
        List<int[]> pq = new ArrayList<>();
        for (int i = 0; i < mat.length; i++) {
            int s = findSoldiers(mat[i]);
            pq.add(new int[] {i, s}); 
        }
        Collections.sort(pq, (a, b) -> Integer.compare(a[1], b[1]));
        for (int i = 0; i < k; i++){
            res[i] = pq.get(i)[0];
        }
        return res;   
    }
    public static int findSoldiers(int[] nums) {
        int s = 0, e = nums.length - 1;

        while (s <= e) {
            int m = s + (e - s) / 2;
            if (nums[m] == 0) e = m  - 1;
            else s = m + 1;
        }
        return e + 1;
    }

    // OPTIMIZED SOLUTION

    public static int[] usingPq (int[][] mat, int k) {
        int[] res = new int[k];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            else return Integer.compare(a[0], b[0]);
        });
        for (int i = 0; i < mat.length; i++) {
            int s = findSoldiers(mat[i]);
            pq.offer(new int[] {i, s}); 
        }

        for (int i = 0; i < k; i++){
            res[i] = pq.poll()[0];
        }
        return res;
    }

}
