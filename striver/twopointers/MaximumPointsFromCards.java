package striver.twopointers;

public class MaximumPointsFromCards {
    public static void main(String[] args) {
        int[] arr = {6, 2, 3, 4, 7, 2, 1, 7, 1};
        System.out.println("Ans: " + maxPointsSum(arr, 4));
    }
    public static int maxPointsSum(int[] arr, int k) {
        int left_sum = 0;
        int right_sum = 0;
        int max_sum = 0;

        for (int i = 0; i < k; i++)  left_sum += arr[i];

        max_sum = left_sum;
        int j = arr.length - 1;
        for (int i = k -1; i >= 0; i--) {
            left_sum  -= arr[i];
            right_sum += arr[j--];
            max_sum = Math.max(max_sum, left_sum + right_sum);
        }
        return max_sum;
    }
}
