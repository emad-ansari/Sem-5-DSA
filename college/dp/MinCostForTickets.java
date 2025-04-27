package dp;

// https://leetcode.com/problems/minimum-cost-for-tickets/description/   [SOLVED]
public class MinCostForTickets {
    public static void main(String[] args) {
        int[] days ={1,4,6,7,8,20};
        int[] costs = {2,7,15};
        System.out.println(mincostTickets(days, costs));
        
    }
    public static  int mincostTickets(int[] days, int[] costs) {
        return fn(0, days.length, days, costs);
        
    }
    public static int fn(int i, int n , int[] days, int[] costs) {
        if (i >= n) return 0;
        int one = costs[0] + fn(i + 1, n, days, costs);

        // for 7 days pass
        int next_indx = i;
        while (next_indx < n &&  days[next_indx] < days[i] + 7 ) next_indx++;

        int seven =  costs[1] + fn(next_indx, n, days, costs);

        int nindx = i;
        while (nindx < n &&  days[nindx] < days[i] + 30 ) nindx++;

        int thirty  = costs[2] + fn(nindx, n, days, costs);

        int min = Math.min(one, seven);
        return Math.min(min, thirty);
    }
    // memoization

    public static int fxn (int i, int n, int[] days, int[] costs, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];
        int one = costs[0] + fn(i + 1, n, days, costs);

        // for 7 days pass
        int next_indx = i;
        while (next_indx < n &&  days[next_indx] < days[i] + 7 ) next_indx++;

        int seven =  costs[1] + fn(next_indx, n, days, costs);

        int nindx = i;
        while (nindx < n &&  days[nindx] < days[i] + 30 ) nindx++;

        int thirty  = costs[2] + fn(nindx, n, days, costs);

        int min = Math.min(one, seven);
        return dp[i] = Math.min(min, thirty);
    }

}
