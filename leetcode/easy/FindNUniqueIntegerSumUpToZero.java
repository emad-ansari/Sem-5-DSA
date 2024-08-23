package leetcode.easy;
import java.util.Arrays;
// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/  - [SOLVED]

public class FindNUniqueIntegerSumUpToZero {
    public static void main(String[] args){
        System.out.println("Ans: " + Arrays.toString(sumZero(5)));

    }
    public static int[] sumZero(int n) {
        if (n == 1){
            return new int[]{0};
        }
        int[] res = new int [n];
        int s = 0;
        int e = n - 1;
        while (s <= e){
            if (s == e){
                // means n was odd
                res[s] = 0;
                break;
            }
            res[s] = n;
            res[e] = -n;
            s++;
            e--;
            n--;
        }
        return res;
    }
}
