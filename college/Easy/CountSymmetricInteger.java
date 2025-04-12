package Easy;

public class CountSymmetricInteger {
    private static boolean[] sym = new boolean[10001];
    static {
        for (int i = 11; i <= 99; i++) {
            if (isSymmetric(i, 2)) sym[i] = true;
        }
        for (int i = 1000; i <= 9999; i++){
            if (isSymmetric(i, 4)) sym[i] = true;
        }
    }
    private static boolean isSymmetric(int n, int l) {
       int sum = 0;
       while (n != 0) {
            if (((int)Math.log10(n) + 1) > l / 2) {
                sum += n % 10;
            }
            else sum -= n % 10; 
            n /= 10;
       }
        return sum == 0;
    }


    public static int countSymmetricIntegers(int low, int high) {
        int cnt = 0;
        for (int i = low; i <= high; i++) {
            if (sym[i]) cnt++;
        }
        return cnt;
    }
    public static void main(String[] args) {
        System.out.println(countSymmetricIntegers(53, 56));
    }

    
}
