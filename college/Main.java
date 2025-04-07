import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        input.close();
        long cnt = 0, prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < prev) {
                cnt += prev - nums[i];
                prev = nums[i];
            }
        }
        System.out.println(cnt);
    }
   
}