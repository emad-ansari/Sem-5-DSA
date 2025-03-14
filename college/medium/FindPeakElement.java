package medium;

// https://leetcode.com/problems/find-peak-element/  [SOLVED]
public class FindPeakElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 1};
        int[] arr2 = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(findPeakElement(arr));
        System.out.println(findPeakElement(arr2));
    }
    public static int findPeakElement(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s < e) {
            int m = s + (e - s) / 2;
            if (m < e && arr[m] < arr[m + 1]) s = m + 1;
            else e = m;
        }
        return s;
    }

}
