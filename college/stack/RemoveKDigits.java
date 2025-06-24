package stack;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "102";

        System.out.println(removeKdigits(num, 2));
    }
    public static String removeKdigits(String num, int k) {
        Stack<Integer> s = new Stack<>();
        int cnt = 0, i = 0, n = num.length();
        while (i < n) {
            if (!s.isEmpty() && s.peek() >= num.charAt(i) - '0') {
                s.pop();
                cnt++;
                if (cnt == k) break;
            }
            s.push(num.charAt(i) - '0');
            i++;
        }
        String ans = "";
        if (i < n) {
            ans += num.substring(i, n);    
        }

        while (cnt < k && !s.isEmpty()) {
            s.pop();
            cnt++;
        }
        while (!s.isEmpty()) {
            ans = s.pop() + ans;
        }

        // remove leading zero if any
        int j = 0;
        while (j < ans.length()) {
            if (ans.charAt(j) != '0') break;
            j++;
        }
        ans = ans.substring(j, ans.length());
        return ans == "" ? "0" : ans;


    }
}
