package Easy;

public class CountLargestGroup {
    public static void main(String[] args) {
        
        // System.out.println(countLargestGroup(13));
        // System.out.println(countLargestGroup(2));
        // System.out.println(countLargestGroup(10));
        // System.out.println(countLargestGroup(1));
        // System.out.println(countLargestGroup(19));
        // System.out.println(countLargestGroup(18));
        // System.out.println(countLargestGroup(7774));
        // System.out.println(countLargestGroup(24));
        // System.out.println(countLargestGroup(130));
        
    }

    public static int countLargestGroup(int n) {
        int[] freq = new int[36];
        for (int i = 1; i <= n; i++) {
            freq[digitSum(i)]++;
        }
        int cnt = 0, maxF = freq[0];
        for (int f: freq) {
            if (f > maxF) {
                maxF = f;
                cnt = 1;
            }
            else if (f == maxF) cnt++;
        }
        return cnt;
    }
    public static int digitSum(int n ) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
