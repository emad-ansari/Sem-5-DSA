package Easy;

import java.util.Arrays;
// https://leetcode.com/problems/relative-sort-array/description/  [SOLVED]

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = { 28, 6, 22, 8, 44, 17 };
        int[] arr2 = { 22, 28, 8, 6 };
        // int[] arr01 = {2,3,1,3,2,4,6,7,9,2,19};
        // int[] arr02 = {2,1,4,3,9,6};

        System.out.println(Arrays.toString(relativeSortArray(arr1, arr2)));
        int m = 2334;
        long a = (long)(m * m );
        long b = (long)m * m ;
        

    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int[] res = new int[arr1.length];
        int max = arr1[0];
        for (int num : arr1) {
            max = Math.max(max, num);
            freq[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (freq[num] != 0) {
                res[i++] = num;
                freq[num]--;
            }
        }
        // add the remaining one
        int s = freq[arr2[arr2.length - 1]]; // 6
        for (int j = s; j <= max; j++) {
            if (freq[j] > 0) {
                while (freq[j] != 0) {
                    res[i++] = j;
                    freq[j]--;
                }
            }
        }
        return res;
    }

    public static int[] relativeSortArray1(int[] arr1, int[] arr2) {
        int[] freq = new int[1001];
        int[] res = new int[arr1.length];
        int max = arr1[0];
        for (int num : arr1) {
            max = Math.max(max, num);
            freq[num]++;
        }
        int i = 0;
        for (int num : arr2) {
            while (freq[num] != 0) {
                res[i++] = num;
                freq[num]--;
            }
        }
        // add the remaining one
        int s = freq[arr2[arr2.length - 1]]; // 6
        for (int j = s; j <= max; j++) {
            while (freq[j] != 0) {
                res[i++] = j;
                freq[j]--;
            }
        }
        return res;
    }
}
