package Easy;

// https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/description/  [SOLVED]

public class SpecialArray {
    public static void main(String[] args) {
        int[] arr = {3, 5}; // 2
        int[] arr1 = {0, 0}; // -1
        int[] arr2 = {0, 4, 3, 0, 4}; // 3
        int[] arr3 = {1}; // 14

        System.out.println(specialArray(arr));
        System.out.println(specialArray(arr1));
        System.out.println(specialArray(arr2));
        System.out.println(specialArray(arr3));

        
    }
    public static int specialArray(int[] arr) {
        int s = 1, e = arr.length;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int cnt = possible(arr, m);
            if (cnt == m) return m;
            else if (cnt < m ) e = m - 1;
            else s = m + 1;
        }
        return -1;
    }
    public static int possible (int[] arr, int x) {
        int cnt = 0;
        for (int num: arr) {
            if (num >= x) cnt++;
        }
        return cnt;
    }
    
}
