package dp;

import java.util.Arrays;

// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended-ii/description

public class MaximumEventAttend {
    public int maxValue(int[][] events, int k) {
        if(k == 1) {
            int max = 0;
            for(int[] event : events) max = Math.max(max, event[2]);
            return max;
        }
        int n = events.length;
        int[][] dp = new int[n + 1][k + 1];

        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = n -1; i >= 0; i--) {
            for (int j = 1; j <= k; j++) {
                int nextIndx  = getNextIndex(events, i, n - 1, events[i][1]);
                dp[i][j] = Math.max(events[i][2] + dp[nextIndx][j - 1], dp[i + 1][j]);
            }
        }

        return dp[0][k];
    }
   
    public int getNextIndex(int[][] events, int s, int e, int currentEventEnd) {
        while (s <= e) {
            int m  = s + (e - s) / 2;
            if (events[m][0] > currentEventEnd) e = m - 1;
            else s = m + 1;
        }

        return s;
    }
    
}
