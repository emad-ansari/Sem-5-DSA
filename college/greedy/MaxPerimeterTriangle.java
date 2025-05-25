package greedy;

import java.util.*;

public class MaxPerimeterTriangle {
    public static void main(String[] args) {

    }
    public static List<Integer> maximumPerimeterTriangle(List<Integer> sticks) {
        List<Integer> list = new ArrayList<>();
        Collections.sort(sticks);
        int n = sticks.size();
        for (int i = n - 1; i >= 2; i--) {
            int a = sticks.get(i - 2);
            int b = sticks.get(i - 1);
            int c = sticks.get(i);
            if (a + b > c) {
                list.add(a);
                list.add(b);
                list.add(c);
                return list;
            }

        }
        list.add(-1);
        return  list;
    }
    
}
