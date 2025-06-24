import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] coins = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(coins[i]);
            }
            Arrays.sort(nums);
            long ps = 0L;
            for (int j = 0; j < n; j++) {
                if (nums[j] <= ps + 1)
                    ps += nums[j];
                else {
                    System.out.print(ps + 1);
                    return;
                }
            }
            System.out.print(ps + 1);
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }

}
