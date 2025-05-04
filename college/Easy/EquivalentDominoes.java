package Easy;

// https://leetcode.com/problems/number-of-equivalent-domino-pairs/?envType=daily-question&envId=2025-05-04  [SOLVED]
public class EquivalentDominoes {
    public int numEquivDominoPairs(int[][] dominoes) {
        int n = dominoes.length;
        if (n == 1) return 0;
        int[][] freq = new int[10][10];

        for (int[] nums: dominoes) {
            if (nums[0] > nums[1]) freq[nums[1]][nums[0]]++;
            else freq[nums[0]][nums[1]]++;
        }
        int ed = 0;
        for (int[] nums: freq) {
            for (int num: nums) {
                ed += num * (num - 1) / 2;
            }
        }
        return ed;
    }
}