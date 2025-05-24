package greedy;

public class ContainerWithmMostWater {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
        
    }

    public static int maxArea(int[] height) {
        int n = height.length, l = 0, r = n -1, max = Integer.MIN_VALUE;
        while (l < r) {
            max = Math.max(max, (Math.min(height[l], height[r]) * (r - l)));
            if (height[l] < height[r]) l++;
            else if (height[l] > height[r]) r--;
            else {
                l++;
                r--;
            }
        }
        return max;
    }
}
