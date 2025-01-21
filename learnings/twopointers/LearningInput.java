package learnings.twopointers;
import java.util.*;

public class LearningInput {
    public static void main(String[] args) {
        List<List<Integer>> list  = new LinkedList<>();

        List<Integer> result = new LinkedList<>();

        result.add(1);
        result.add(2);
        result.add(3);
        list.add(result);
        List<Integer> ans2 = new LinkedList<>();
        ans2.add(3);
        ans2.add(5);
        ans2.add(10);
        list.add(ans2);


        // Print using deepToString
        System.out.println((list));
    }

    public static void printOutput(int[] nums){
        for (int num: nums){
            System.out.print(num + " ");
        }
    }

}