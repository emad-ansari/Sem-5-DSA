package learnings.twopointers;

public class MaxSumkConsecutiveElement {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 3, 3, 4, 5, -1};
        System.out.println("Ans: " + maxSum(arr, 4));

    }
    public static int maxSum(int[] arr, int k){
        if (arr.length < k){
            return 0;
        }
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        int maxSum = sum;
        int l = 0;
        int r = k - 1;
        while (r < arr.length - 1){
            sum = sum - arr[l];
            l++;
            r++;
            sum = sum + arr[r];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
