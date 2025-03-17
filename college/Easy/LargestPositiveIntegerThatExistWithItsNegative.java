package Easy;


// https://leetcode.com/problems/largest-positive-integer-that-exists-with-its-negative/description/  [SOLVED]
public class LargestPositiveIntegerThatExistWithItsNegative {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,3};
        int[] nums1 = {-1,10,6,7,-7,1};
        int[] nums2 = {-10,8,6,7,-2,-3};

        System.out.println(findMaxK(nums));
        System.out.println(findMaxK(nums1));
        System.out.println(findMaxK(nums2));
        
    }
    public static int findMaxK(int[] nums) {
        int maxK = -1;
        int[] freq = new int[2001];
        for (int num: nums) freq[num + 1000]++;
        for (int num: nums) {
            if (num > 0 && freq[num + 1000] > 0 && freq[(-1) * num + 1000] > 0) {
                maxK = num > maxK ? num : maxK;
            }
        }
        return maxK;
    }

    // OPTIMIZED
    public static int findMaxK1(int[] nums) {
        int maxK = -1;
        boolean[] isExist  = new boolean[1001];
        for (int num: nums) {
            if (num < 0) isExist[-num]= true;
        }
        for (int num: nums) {
            if (num > 0 && isExist[num]) {
                maxK = Math.max(maxK, num);
            }
        }
        return maxK;
    }
} 
