package greedy;

// https://leetcode.com/problems/gas-station/description/  [SOLVED]
public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};
        System.out.println(canCompleteCircuit(gas, cost));
    }
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, start = 0, currGas = 0;
        int tg = 0, tc = 0;
        for (int i = 0; i < n; i++) {
            tc += cost[i];
            tg += gas[i];
        }
        if (tg < tc) return -1;
        for (int i = 0; i < n; i++) {
            currGas = currGas + gas[i] - cost[i];
            if (currGas < 0) {
                start = (i + 1) % n;
                currGas = 0;
            }
        }
        return start;
        
    }
}