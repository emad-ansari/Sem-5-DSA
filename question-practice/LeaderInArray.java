import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class LeaderInArray {
    public static void main (String[] args) {
        int [] arr = {16, 17, 4, 3, 5, 2};
        // 16, 15, 14, 13, 12;
        System.out.println(findLeaders(arr));
    }
    public static ArrayList<Integer> findLeaders(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> leaders = new ArrayList<>();
        int last_leader =  arr[n - 1];
        leaders.add(last_leader);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= last_leader) {
                last_leader = arr[i];
                leaders.add(arr[i]);
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
