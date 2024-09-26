package leetcode.medium;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
// [UNSOLVED]
public class findNthUglyNumber {
    public static void main(String[] args){
        System.out.println("Nth ugly number: " + nthUglyNumber(11));

    }
    public static int nthUglyNumber(int n){
        Set<Integer> set = new HashSet<>();
        int i = 1;
         while (i < n) {
            int firstUgly = i * 2;
            int secondUgly = i * 3;
            int thirdUgly = i * 5;
            set.add(firstUgly);
            set.add(secondUgly);
            set.add(thirdUgly);
            i++;
        }
        set.add(1);
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
        // now iterate over the list and find the nth ugly number
        return list.get(n - 1);
    }
}
