package stack;

import java.util.Stack;
// https://leetcode.com/problems/online-stock-span/ [SOLVED]

public class OnlineStockPan {

    private Stack<int[]> cg;
    int indx = 0;
    public OnlineStockPan() {
        cg = new Stack<>();
    }
    
    public int next(int price) {
        if (cg.isEmpty()) {
            cg.push(new int[]{price, indx++});
            return 1;
        }
        while (!cg.isEmpty() && price >= cg.peek()[0]) cg.pop();
        int val = cg.isEmpty() ? indx + 1 : indx - cg.peek()[1];
        cg.push(new int[]{price, indx++});
        return val;
    }
    public static void main(String[] args) {
        
        int[] nums = {100, 80, 60, 70, 60, 75, 85};
        OnlineStockPan obj = new OnlineStockPan();
        for (int i = 0; i < nums.length; i++) {
            System.out.print(obj.next(nums[i]) + " ");
        }
    }
    
}