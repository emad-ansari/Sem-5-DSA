package Easy;

import java.util.Arrays;

public class SubsequenceWithLengthKWithLargestSum {

    static class Pair {
        int num, indx;
        Pair(int num, int indx) {
            this.num = num;
            this.indx = indx;
        }
    }
    public static int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        Pair[] arr = new Pair[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        Arrays.sort(arr, (a, b) -> a.num - b.num );

        Pair[] sorted = new Pair[k];

        for (Pair p: arr) {
            System.out.println("[" + p.num + ", " +  p.indx + "]");
        }
        int j = n - 1;
        int l = 0;
        int cnt = 0;
        while (j >= 0 && cnt < k) {
            cnt++;
            sorted[l++] = arr[j--];
        }
        Arrays.sort(sorted, (a, b) -> a.indx - b.indx);

        int res[] = new int[k];
        for (int i = 0; i < k; i++) res[i] = sorted[i].num;
        System.out.println();

        return res;
    }

    
    public static void main(String[] args) {
        int[] nums = {3,4,3,3};
        int k = 2;

        
        System.out.println(Arrays.toString(maxSubsequence(nums, k)));

    }
    
}
