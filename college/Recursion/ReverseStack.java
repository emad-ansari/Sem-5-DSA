package Recursion;

import java.util.Stack;
// https://www.geeksforgeeks.org/problems/reverse-a-stack/1  [SOLVED]
public class ReverseStack {
   
    static void reverse(Stack<Integer> s)
    {
        // add your code here
        if (s.isEmpty()) return;
        int top = s.pop();
        reverse(s);
        helper(s, top);
        
    }
    public static void helper(Stack<Integer> s, int top) {
        if (s.isEmpty()){
            s.push(top);
            return;
        }
        else {
            int x = s.pop();
            helper(s, top);
            s.push(x);       
        }
    }
}