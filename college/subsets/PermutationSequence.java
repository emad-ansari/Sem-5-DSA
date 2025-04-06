package subsets;

import java.util.Arrays;


public class PermutationSequence {
    public static void main(String[] args) {
        System.out.println(getPermutation2(4, 18));
    }


     // new method
    public static String getPermutation1(int n, int k) {
        // generate sequence string for proccess
        StringBuilder str = new StringBuilder(n);

        for (int i = 1; i <= n; i ++) {
            str.append("" + i);
        }
        for (int j = 1; j < k; j++) {
            nextPermutation(str);
        }
        return str.toString();
    }

    public static void nextPermutation(StringBuilder str) {
        int n = str.length();
        if (n == 1) return;
        int i = n - 2;
        while (i >= 0 && str.charAt(i) >= str.charAt(i + 1)) i--;
        // sort the array from i + 1 to n - 1; and return
        if (i < 0) {
            char[] c = str.toString().toCharArray();
            Arrays.sort(c, i + 1, n);
            str.delete(0, n);
            str.append(String.valueOf(c));
            return;
        }
        // find next greater element
        int j = search(str, i + 1, n - 1, str.charAt(i));
        char temp = str.charAt(i);
        str.setCharAt(i, str.charAt(j));
        str.setCharAt(j, temp);

        char[] c = str.toString().toCharArray();
        Arrays.sort(c, i + 1, n);
        str.delete(0, n);
        str.append(String.valueOf(c));
    }
    private static int search (StringBuilder str, int s , int e, char t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (t < str.charAt(m)) s = m + 1;
            else e = m - 1;
        }
        return e;
    }

    public static String getPermutation(int n, int k) {
        // generate sequence string for proccess
        StringBuilder str = new StringBuilder(n);

        for (int i = 1; i <= n; i ++) {
            str.append("" + i);
        }
        backtrack(new StringBuilder("") , str, n, k, new int[] {0});
        return str.toString();
    }
    private static void backtrack(StringBuilder p, StringBuilder up, int n, int k, int[] cnt) {
        if (p.length() == n) {
            cnt[0]++; 
            if (cnt[0] == k) {
                up.delete(0, n);
                up.append(p);
            }
            return ;
        }

        // if cnt < k then only do following thing
        if (cnt[0] < k) {
            for (int i = 0; i < up.length(); i++) {
                // if char is not included in p string then include it , otherwise check for the next one
                if (p.indexOf(up.charAt(i) + "") < 0) {
                    p.append(up.charAt(i));
                    backtrack(p, up, n, k, cnt);
                    p.deleteCharAt(p.length() - 1);
                }
            }
        }
        return;   
    }

    // Optimal Solution
    public static String getPermutation2(int n, int k) {
        // generate sequence string for proccess
        int f = factorial(n - 1);
        int d = k % f  == 0 ? k / f - 1 : k / f;
        int[] nums = new int[n];
        nums[0] = d + 1;
        int j = 1;
        for (int i = 1; i <= n; i++) {
            if (i == d + 1) continue;
            nums[j++] = i;

        }
        
        k = k - (f * d);

        for (int t = 1; t < k; t++) {
            nextPermutation(nums);
        }
        StringBuilder str = new StringBuilder(nums.length);
        for (int num: nums) {
            str.append(num + "");
        }
        return str.toString();
    }
   
    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n == 1) return;
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        // sort the array from i + 1 to n - 1; and return
        if (i < 0) {
            reverse(nums, i + 1, n -1);
            return;
        }
        // find next greater element
        int j = search(nums, i + 1, n - 1, nums[i]);
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        // Arrays.sort(nums, i + 1, n);
        reverse(nums, i + 1, n -1);
        // sort from i + 1 to n - 1;
    }
    private static int search (int[] nums, int s , int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (t < nums[m]) s = m + 1;
            else e = m - 1;
        }
        return e;
    }
    public static void reverse(int[] nums, int s, int e) {
        while (s <= e) {
            int temp = nums[s];
            nums[s] = nums[e];
            nums[e] = temp;
            s++;
            e--;
        }
    }
    private static int factorial(int n) {
        int fac = 1; 
        for (int i = 2; i <= n; i++) {
            fac *= i;
        }
        return fac;
    }

}
