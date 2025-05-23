package codeforces;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BSale {
    public static void main(String[] args)  throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String[] input = br.readLine().split(" ");
            String[] temp  = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int[] nums = new int[n];
            int ans  = 0;
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(temp[i]);
            }
            Arrays.sort(nums);
            for (int i = 0; i < m; i++) {
                if (nums[i] < 0) ans += -nums[i];
            }
            System.out.print(ans);
        }
    }
    
}
