package Easy;

// https://leetcode.com/problems/find-missing-and-repeated-values/  [SOLVED]
public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        
    }
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int[] ans = new int[2];
        int[] freq = new int[n * n + 1];
        for (int[] row: grid) {
            for (int num: row) freq[num]++;
        }
        for (int i = 1; i < freq.length; i++) {
            if (freq[i] > 1) ans[0] = i;
            else if (freq[i] == 0) ans[1] = i;
            else if (ans[0] != 0 && ans[1] != 0) break;
        }
        return ans;
    }
}
