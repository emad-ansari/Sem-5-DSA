package strings;
import java.util.Scanner;
public class ConvertString {
// [x]
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        String t = input.nextLine();
        System.out.println(isPossible(s, t));
        input.close();        
    }
    public static boolean isPossible(String s, String t) {
        int m = s.length(), n = t.length(),  i = m - 1, j = n -1;
        while (i >= 0 && j >= 0) {
            if (s.charAt(i) == t.charAt(j)) {
                i--;
                j--;
            }
            else j--;
        }
        return i == j;
    }
    
}
