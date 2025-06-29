package stack;

import java.util.Stack;
// https://leetcode.com/problems/remove-duplicate-letters/description/?envType=problem-list-v2&envId=greedy

public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        Stack<Character> st = new Stack<>();

        for (char ch: s.toCharArray()) freq[ch - 'a']++;

        for (char ch: s.toCharArray()) {
            freq[ch - 'a']--;  
            if (vis[ch - 'a']) continue;

            while (!st.isEmpty() && ch < st.peek() && freq[st.peek() - 'a'] > 0){
                vis[st.pop() - 'a'] = false;
            }
            
            st.push(ch);
            vis[ch - 'a'] = true;
            
        }

        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()) sb.append(st.pop());

        return sb.reverse().toString();
    }
    
}
