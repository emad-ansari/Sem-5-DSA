package leetcode.easy;
import java.util.*;
// https://leetcode.com/problems/implement-stack-using-queues/description/ [SOLVED]

public class QueueWithStack {
    Queue<Integer> q;

    public QueueWithStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.offer(x);
        for (int i = 0; i < q.size() - 1; i++){
            q.offer(q.poll());
        }
    }

    public int pop() {
        return q.poll();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
}
