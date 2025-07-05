package greedy;
// https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone

public class MinimumMoveToSeatEveryOne {
    int SIZE = 101;
    public int minMovesToSeat(int[] seats, int[] students) {
        int n = seats.length, minMove = 0;

        int[] seat = new int[SIZE];
        int[] student = new int[SIZE];

        for (int i = 0; i < n; i++) {
            seat[seats[i]]++;
            student[students[i]]++;
        }

        int l = 1, r = 1;
        while (l < SIZE && r < SIZE) {
            if (seat[l] == 0 && student[r] == 0) {
                l++;
                r++;
            }
            else if (seat[l] == 0 && student[r] != 0) l++;
            else if (seat[l] != 0 & student[r] == 0) r++;
            else {
                minMove += Math.abs(l - r);
                seat[l]--;
                student[r]--;
                if (seat[l] == 0) l++;
                if (student[r] == 0) r++;
            }
        }
        return minMove;
    }
    
}
