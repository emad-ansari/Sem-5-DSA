package leetcode.easy;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/add-to-array-form-of-integer/ -[SOLVED]
public class AddToArrayFormOfInteger {
    public static void main(String[] args){
        int[] num = {2,7, 4};
        System.out.println("ans: "  + addToArrayForm(num, 181));

    }
    public static List<Integer> addToArrayForm(int[] num, int k){
        LinkedList<Integer> ans = new LinkedList<>();
        int carry = 0;
        int sum = 0;
        int i = num.length - 1;
        while (k > 0 || i >= 0) {
            if (i >= 0) {
                sum = (k % 10) + num[i] + carry;
            }
            else {
                sum = (k % 10) + carry;
            }
            carry = sum > 9 ? 1 : 0;
            ans.addFirst(sum % 10);
            k /= 10;
            i--;
        }
        if (carry == 1){
            ans.addFirst(carry);
        }

        return ans;

    }
}
