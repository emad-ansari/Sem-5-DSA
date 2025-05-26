package greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public static void main(String[] args) {
        

    }
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int [] b) {
                return Integer.compare(a[0], b[0]);
            }
        });


        int count = 0, n = intervals.length, l = 0;
        for (int r = 1; r < n; r++) {
            if (intervals[r][0] < intervals[l][1]) {
                count++;
            }
            if (intervals[r][0] >= intervals[l][1] || intervals[l][1] > intervals[r][1]) {
                l = r;
            }
        }

        return count;
    }
    
}
