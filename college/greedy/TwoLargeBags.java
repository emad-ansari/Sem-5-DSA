package greedy;
import java.io.*;
public class TwoLargeBags {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            int m = 1001;
            
            int tt = Integer.parseInt(br.readLine());
            while (tt-- != 0) {
                int n = Integer.parseInt(br.readLine());
                String[] in = br.readLine().split(" ");
                int[] freq = new int[m];
                for (int i = 0; i < n; i++) {
                    int num = Integer.parseInt(in[i]);
                    freq[num]++;
                }
                boolean isPos = true;
                for (int i = 0; i < m; i++) {
                    if (freq[i] >= 2) {
                        if (i == m - 1) {
                            if (freq[i] % 2 != 0) isPos = false;
                            break;
                        }
                        freq[i + 1] += freq[i] - 2;
                    }
                    else if (freq[i] == 1) {
                        isPos = false;
                        break;
                    }
                }
                System.out.println(isPos ? "YES": "NO");
            }
        }
    }
    
}
