package greedy;

// https://www.geeksforgeeks.org/problems/largest-number-with-given-sum-1587115620/1  [SOLVED]

public class LargestNumberWithGivenSum {
    public static void main(String[] args) {
        int N = 5;
        int sum = 12;
        System.out.println(largestNumber(N, sum));
    }
    public static String largestNumber(int n, int sum) {
        StringBuilder ans = new StringBuilder();
        
        int tsum = n * 9;
        if (tsum < sum) return "-1";
        for (int i = 1; i <= n; i++) {
            if (9 <= sum) {
                ans.append("9");
                sum -= 9;
            }
            else if (sum == 0) ans.append("0");
            else {
                ans.append(Integer.toString(sum));
                sum = 0;
            }
        }
        return ans.toString();
    }
}
