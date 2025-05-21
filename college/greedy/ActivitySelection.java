package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.geeksforgeeks.org/problems/activity-selection-1587115620/1  [SOLVED]
public class ActivitySelection {
    public int activitySelection(int[] start, int[] finish) {
        // code here.
        int n = start.length;
        List<int[]> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) {
            list.add(new int[] {start[i], finish[i]});
        }
        // sort the list using comparator
        Collections.sort(list, (a, b) -> Integer.compare (a[1] , b[1]));
        
        int count = 1;
        int currSlot = list.get(0)[1];
        for (int i = 1; i < n; i++) {
            if (list.get(i)[0] > currSlot) {
                count++;
                currSlot = list.get(i)[1];
            }
            
        }
        return count;
    }
    
}
