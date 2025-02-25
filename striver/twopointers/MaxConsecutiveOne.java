package striver.twopointers;

//https://leetcode.com/problems/max-consecutive-ones/description/ [EASY]  [SOLVED]

//https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1554559819/ [MEDIUM] [SOLVED]
public class MaxConsecutiveOne {
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        System.out.println(maxConsecutiveOnes(arr));
    }

    public static int maxConsecutiveOnes(int[] arr) {
        int l = 0;
         int r = 0;
         int maxLength = 0;
         while (r < arr.length) {
             if (arr[r] == 1) {
                 maxLength = Math.max(maxLength , r - l + 1);
             }
             else {
                 l = r + 1;
             }
             r++;
         }
         return maxLength;
    }
    public static int maxConsecutiveOnesThird (int[] arr, int k) {
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeros = 0;
        while (r < arr.length) {
            if (arr[r] == 0) zeros++;
            while (zeros > k) {
                if (arr[l] == 0) {
                    zeros--;
                }
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);

            r++;
        }
        return maxLen;
    }


}
