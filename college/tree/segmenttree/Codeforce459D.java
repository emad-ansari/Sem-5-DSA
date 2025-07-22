package tree.segmenttree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Codeforce459D {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            int[] nums = new int[n];
            String[] arr = br.readLine().split(" ");
            for (int i = 0; i < n ;i++ ){
                nums[i] = Integer.parseInt(arr[i]);
            }
            
            
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            
        }

    }

}
