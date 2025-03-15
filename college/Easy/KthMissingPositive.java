package Easy;

// https://leetcode.com/problems/kth-missing-positive-number/description/ 

public class KthMissingPositive {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        // int[] arr1 = {1,2,3,4};

        System.out.println(findKthPositive1(arr, 5));
        // System.out.println(findKthPositive(arr1, 2));
    }
    public static int findKthPositive(int[] arr, int k) {
        int cnt = 0, mpn = 0, i = 1;
        while(cnt != k) {
            if (!isExist(arr, i)) {
                mpn = i;
                cnt++;
            }
            i++;
        }
        return mpn;
    }
    public static boolean isExist(int[] arr, int n) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int m = s + (e  - s) / 2;
            if (arr[m] == n) return true;
            else if (n < arr[m]) e = m - 1;
            else s = m + 1;
        }
        return false;
    }

    // Optimized
    public static int findKthPositive1(int[] nums, int k) {
        int s = 0;
        int e = nums.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            int missing = nums[m] - m - 1;
            if (missing < k) s = m + 1;
            else e = m - 1;
        }
        return s + k;
    }
}
