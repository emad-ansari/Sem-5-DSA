package Recursion;

import java.util.Stack;
// https://www.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1  [SOLVED]
public class DeleteMidFromStack {

    public void deleteMid(Stack<Integer> s) {
        // code here
        helper(s, s.size()/ 2);
    }
    public static void helper(Stack<Integer> stack, int m) {
        if (m == 0) {
            stack.pop();
            return;
        }
        int top = stack.pop();
        helper(stack, m - 1);
        stack.push(top);
    }
}
