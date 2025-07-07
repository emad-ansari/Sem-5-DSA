package greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxEvent {
    public static void main(String[] args) {
        int[][] events = { { 26, 27 },
                { 24, 26 },
                { 1, 4 },
                { 1, 2 },
                { 3, 6 },
                { 2, 6 },
                { 9, 13 },
                { 6, 6 },
                { 25, 27 },
                { 22, 25 },
                { 20, 24 },
                { 8, 8 },
                { 27, 27 },
                { 30, 32 }
        };
        System.out.println(maxEvents(events));
    }

    public static int maxEvents(int[][] events) {

        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(a, b));

        int day = events[0][0], count = 0, n = events.length, i = 0;

        while (!pq.isEmpty() || i < n) {
            while (i < n && events[i][0] == day) {
                pq.offer(events[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }

            day++;

            while  (!pq.isEmpty()  && pq.peek() < day) pq.poll();
        }
        return count;
    }

}
