package Recursion;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//https://www.geeksforgeeks.org/problems/queue-reversal/1  [SOLVED]
public class ReverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(queue);
        System.out.println(reverseQueueUsingStack(queue));
        
    }
    public Queue<Integer> reverseQueue(Queue<Integer> queue) {
        // code here.
        if (queue.size() == 0) {
            return queue;
        }
        int f = queue.poll();
        reverseQueue(queue);
        queue.offer(f);
        return queue;
    }

    // Reverse queue using stack [TODO]
    public static Queue<Integer> reverseQueueUsingStack(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.isEmpty() ) {
            queue.offer(stack.pop());
        }   
        return queue;

    }
}
