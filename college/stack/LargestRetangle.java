package stack;

import java.util.Stack;

public class LargestRetangle {
    public static void main(String[] args) {
        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
        
    }
    public static int  largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> prevs = new Stack<>();
        Stack<Integer> nexts = new Stack<>();
        int[] preva = new int[n];
        int[] nexta = new int[n];
        // prevsmaller
        for (int i = 0; i < n; i++) {
            while (!prevs.isEmpty() && heights[i] <= heights[prevs.peek()]) prevs.pop();
            if (prevs.isEmpty()) preva[i] = -1;
            else preva[i] = prevs.peek();
            prevs.push(i);
        }
        // next smaller
        for (int i = n - 1; i >= 0; i--) {
            while (!nexts.isEmpty() && heights[i] <= heights[nexts.peek()]) nexts.pop();
            if (nexts.isEmpty()) nexta[i] = n;
            else nexta[i] = nexts.peek();
            nexts.push(i);
        }

        // cal
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int temp_res = (nexta[i] - preva[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, temp_res);
        }
        return maxArea;
    }
}
