package slidingwindow;

import java.util.Scanner;
// https://leetcode.com/problems/permutation-in-string/description/  [SOLVED]

public class PermutationInString {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the code: ");
        String code = input.nextLine();
        System.out.print("Enter the letter: ");
        String letter = input.nextLine();
        System.out.println(isContains(code, letter));
        input.close();
        

    }
    public static boolean isContains(String code, String letter) {
        int l = 0, r = 0, n = letter.length(), cnt = 0;
        int[] freq = new int[26];
        for (char c: code.toCharArray()) {
            freq[c - 'a']++;
            cnt++;
        }
        
        while (r < n) {
            while (r - l + 1 > code.length()) {
                freq[letter.charAt(l) - 'a']++;
                if (freq[letter.charAt(l) - 'a'] > 0) cnt++;
                l++;
            }
            if (freq[letter.charAt(r) - 'a'] > 0) cnt--;
            freq[letter.charAt(r) - 'a']--;
           
            if (cnt == 0) return true;
            r++;

        }
        return false;
    }
    
}
