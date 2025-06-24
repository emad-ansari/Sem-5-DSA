import java.util.Arrays;

public class Temp {
    public static void main(String[] args) {
        // int[] nums = { 1, 7};
        // System.out.println(Arrays.toString(findPrefix(nums)));
        // System.out.println(Arrays.toString(findSuffix((nums))));
        // System.out.println(pivotIndex(nums));
        // int[][] mat = {
        //     {10, 20, 30},
        //     {5, 10, 20},
        //     {2, 4, 6}
        // };
        // prefixSumInMatrix(mat);

        int[] nums = {1, 2, 0, 4, 5};
        int[] num1 = {1, 2, 3, 4, 1};
        int[] num2 = {1, 2, 3, 4, 5};
        int[] num3 = {5, 2, 3, 4, 5};
        System.out.println(isSorted(nums, 5));
        System.out.println(isSorted(num1, 5));
        System.out.println(isSorted(num2, 5));
        System.out.println(isSorted(num3, 5));
        
    }

    public static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = nums[i] + pre[i - 1];
        }

        if (pre[n - 1] - nums[0] == 0 || pre[n - 1] == 0)
            return 0;
        for (int i = 1; i < n - 1; i++) {
            if (pre[i - 1] == pre[n - 1] - pre[i])
                return i;
        }
        return -1;
    }

    public static int[] findPrefix(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }
    public static int[] findSuffix(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            nums[i] += nums[i + 1];
        }
        return nums;
    }

    public static int minStartValue(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0] < 1 ? (-1) * nums[0]  + 1 : nums[0];  
        }
        int min = Math.min(1, nums[0]);
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i -1];
            min = Math.min(min, nums[i]);
        }
        return min < 1 ? (-1)* min + 1 : min;
    }


    // Reshape matrix
    public static int[][] matrixReshape (int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if ((m == r && n == c) || (r * c != m * n)) return mat;
        int[][] res = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = mat[row][col++];
                if (col == n) {
                    row++;
                    col = 0;
                }
            }
        }
        return res;
    }
    // Reachest customer wealth
    public static int maxWealth(int[][] accounts) {
        int maxw = 0;
        for (int[] customer: accounts) {
            int sum = 0;
            for (int w: customer) {
                sum += w;
            }
            maxw = Math.max(maxw, sum);
        }
        return maxw;
    }

    // Count Negative number in matrix
    public static int countNegative (int[][] mat) {
        int n = mat[0].length;
        int nc = 0;
        for (int[] nums: mat) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int m = l + (r - l ) / 2;
                if (nums[m] < 1) r = m - 1;
                else l = m + 1;
            }
            nc += l == n ? 0 : n - l;
        }
        return nc;
    }

    // Matrix Diagonal Sum
    public static int diagonalSum(int[][] mat) {
        int n = mat.length;
        int r = 0, fc = 0, sc = n - 1, sum = 0;
        while (r < n && fc < n && sc >= 0) {
            if (fc == sc) {
                sum += mat[r][fc];
            }
            else sum += mat[r][fc] + mat[r][sc];
            r++;
            fc++;
            sc--;
        }
        return sum;
    }

    // 1D to 2D array
    public static int[][] construct2DArray(int[] nums, int m, int n) {
        if (m * n != nums.length) return new int[][] {};
        int[][] mat = new int[m][n];
        int r = 0, c = 0;
        for (int num: nums) {
            mat[r][c++] = num;
            if (c == n) {
                c = 0;
                r++;
            }
        }
        return mat;
    }

    // prefix sum in matrix
    public static void prefixSumInMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] pref = new int[m][n];
        pref[0][0] = mat[0][0];
        for (int j = 1; j < n; j++) pref[0][j] = pref[0][j - 1] + mat[0][j];
        for (int i = 1; i < m; i++) pref[i][0] = pref[i - 1][0] + mat[i][0];

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                pref[i][j] = mat[i][j] + pref[i][j - 1] + pref[i - 1][j] - pref[i - 1][j - 1];
            }
        }

        System.out.println(rangeSum(pref, 1, 2, 1, 2));
    }
    // Range Sum Query
    public static int rangeSum(int[][] pref, int r1, int r2, int c1, int c2) {
        int ls = c1 == 0 ? 0 : pref[r2][c1 - 1];
        int us = r1 == 0 ? 0 : pref[r1 - 1][c2];
        int cs = r1 == 0 && c1 == 0 ? 0 : pref[r1 - 1][c1 - 1];
        return pref[r2][c2] - ls - us + cs;
    }

    // Tail recursion for finding factorial
    public static int fac(int n, int ans) {
        if (n == 1) return ans;
        return fac(n - 1, n * ans);
    } 
    // Checking Whether array is sorted or not.
    public static boolean isSorted(int[] arr, int n) {
        if (n == 1) return true;
        if (arr[n - 1] < arr[n - 2]) return false;
        return isSorted(arr, n -1 );
    }

    public static void prefIn2D(int[][] mat) {
        int n = mat.length;
        int[][] pref = new int[n][n];
        pref[0][0] = mat[0][0];
        for (int col = 1; col < n; col++) {
            pref[0][col]  = mat[0][col]  + pref[0][col - 1];
        }
        for (int row = 1; row < n; row++) {
            pref[row][0] = mat[row][0] + pref[row][0];
        }
        for (int row = 1; row < n; row++){
            for (int col = 1; col < n; col++) {
                pref[row][col] = mat[row][col] + pref[row - 1][col] + pref[row][col - 1]  + pref[row -1][col - 1];
            }
        }
        for (int[] nums: pref) {
            System.out.println(Arrays.toString(nums));
        }
    }



}
