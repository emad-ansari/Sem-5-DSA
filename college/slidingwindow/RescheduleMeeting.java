package slidingwindow;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i
public class RescheduleMeeting {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        int n = startTime.length;

        List<Integer> gaps = new ArrayList<>();

        gaps.add(startTime[0]);

        for (int i = 1; i < n; i++) {
            gaps.add(startTime[i] - endTime[i - 1]);
        }
        gaps.add(eventTime - endTime[n - 1]);
        
        int l = 0, r = 0, max = 0, sum = 0;
        while (r < gaps.size()) {
            sum += gaps.get(r);
            if (r - l + 1 > k + 1) {
                sum -= gaps.get(l);
                l++;
            }

            max = Math.max(max, sum);
            r++;
        }
        return max;
    }
}
