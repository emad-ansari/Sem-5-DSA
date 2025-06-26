package rangequery;
import java.util.Scanner;
import java.util.Arrays;

public class MosAlgo {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = input.nextInt();
        int sqrt = (int)Math.sqrt(n);
        int[] pref = new int[sqrt + 1];

        // divide into chunks 
        int id = -1;
        for (int i = 0; i < n; i++) {
            if (i % sqrt == 0) id++;
            pref[id] += nums[i];
        }
        System.out.println(Arrays.toString(pref));
        int q = input.nextInt();
        
        while (q-- != 0) {
            int l = input.nextInt();
            int r = input.nextInt();
            System.out.println(query(nums, pref, l, r));
        }

        input.close();
    }
    public static int query(int[] nums, int[] pref, int l, int r) {
        int res = 0;
        int n = nums.length;
        int sqrt = (int)Math.sqrt(n);
        // left 
        while (l % sqrt != 0 && l <= r && l != 0) {
            res += nums[l++];
        }
        // middle part
        while (l + sqrt <= n) {
            res += pref[l / sqrt];
        }
        // right part
        while (l <= r) {
            res += nums[l++];
        }
        return res;

    }
}
