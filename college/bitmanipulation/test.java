import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of workers: ");
        int n = in.nextInt();
        int[] days = new int[n];
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the " +  i  + "th worker available days: ");
            int m = in.nextInt();
            int mask = 0;
            for (int j = 0; j < m; j++) {
                int day = in.nextInt();
                mask = mask ^ (1 << (day - 1));
            }
            days[i] = mask;
        }
   
        for (int i = 0; i < n; i++) {
            int num = days[i];
            StringBuilder sb = new StringBuilder();
            while (num != 0) {
                sb.append(num %  2);
                num /= 2;
            }
            System.out.println(sb.reverse());
        }

        in.close();

    }

    public static void MaxDays(int[] days) {
        int n = days.length;
        int max = Integer.MIN_VALUE;
        int w1 = 0;
        int w2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int and = days[i] & days[j];
                int cnt = 0;
                while (and != 0) {
                    cnt++;
                    and = and & (and - 1);
                }
                if (cnt > max) {
                    max = cnt;
                    w1 = days[i];
                    w2 = days[j];
                }
                
            }
        }
        System.out.println("First worker" + w1);
        System.out.println("second worker: " + w2);
    }
    
    
}
