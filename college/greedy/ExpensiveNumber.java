package greedy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExpensiveNumber {
    public static void main(String[] args) throws IOException{

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int tt = Integer.parseInt(br.readLine());
            while (tt-- != 0) {
                String s = br.readLine();
                int e = s.length() - 1;
                int count = 0;
                while (s.charAt(e) == '0') {
                    count++;
                    e--;
                }

                for (int i = 0; i < e ; i++) {
                    if (s.charAt(i) != '0') count++;
                }
                System.out.println(count);
            }
        }
        
    }
    
    
}
