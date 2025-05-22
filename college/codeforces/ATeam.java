package codeforces;
import java.util.*;
public class ATeam {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)){
            int n = input.nextInt();
            int ans = 0;
            while (n-- > 0) {
                int count = 0;
                for (int i = 0; i < 3; i++) {
                    int num = input.nextInt();
                    if (num == 1) count++;
                }
                if (count >= 2) ans++;
            }
            System.out.print(ans);
        }
    }
    
}
