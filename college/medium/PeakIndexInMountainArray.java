package medium;
// https://leetcode.com/problems/peak-index-in-a-mountain-array/description/ [SOLVED]


public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr = {0, 2, 3, 4, 5, 2, 1, 0};
        System.out.println(peakIndexMountainArray(arr));
    }
    public static int peakIndexMountainArray(int[] arr) {
        if (arr.length == 3) return arr[1];
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (arr[m] < arr[m + 1]) s = m + 1;
            else e = m;
        }
        return s;
    }
    
}
