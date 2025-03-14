package Easy;

// https://leetcode.com/problems/valid-mountain-array/description/  [SOLVED]
public class ValidMountainArray {
    public static void main(String[] args) {
        int[] arr = {2, 1};
        int[] arr1 = {3, 5, 5};
        int[] arr2 = {0, 3, 2, 1};
        int[] arr3 = {0, 2, 3, 4, 5, 2, 1, 0};
        int[] arr4 = {0, 2, 3, 3, 5, 2, 1, 0};
        int[] arr5 = {0,1,2,3,4,5,6,7,8,9};
        System.out.println(validMountainArray(arr));
        System.out.println(validMountainArray(arr1));
        System.out.println(validMountainArray(arr2));
        System.out.println(validMountainArray(arr3));
        System.out.println(validMountainArray(arr4));
        System.out.println(validMountainArray(arr5));
        
    }
    public static boolean validMountainArray(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int i = 1;
        while (i < n && arr[i] > arr[i - 1]) i++;

        if (i == 1 || i >= n || (i < n && arr[i] == arr[i - 1])) return false;
        i = i + 1;
        while (i < n && arr[i] < arr[i - 1]) i++;
        return i >= n;
    }
}
