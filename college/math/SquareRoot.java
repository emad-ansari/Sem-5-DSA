package math;

public class SquareRoot {
    public static void main(String[] args) {
        int n = 101;
        System.out.println(binarySearchSqrt(n));
    }
    /*
     * Brute Force Approach: find the floor value of sqrt of n
     * Time Complexity: O(sqrt(n))
     */
    public static int sqrt(int n){
        int i = 1;

        while (i * i <= n) {
            i++;
        }
        return i - 1;
    }

    /*
     * Optimized Approach: Binary Search on range 1 to n
     * Time Complexity: O(log(n))
    */
    
    public static int binarySearchSqrt(int n) {
        int s = 1, e = n;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (m <= n / m) {
                s = m + 1;
            } 
            else e = m - 1;
        }
        return e;
    }

}
