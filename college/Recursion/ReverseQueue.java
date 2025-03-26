package Recursion;

import java.util.Queue;

//https://www.geeksforgeeks.org/problems/queue-reversal/1  [SOLVED]
public class ReverseQueue {
    public static void main(String[] args) {
        
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
    // public static Queue<Integer> reverseQueueUsingStack(Queue<Integer> queue) {
        
    // }

}
