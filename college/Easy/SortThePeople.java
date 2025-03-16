package Easy;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/sort-the-people/description/  [SOLVED]
public class SortThePeople {
    public static void main(String[] args) {
        
    }
    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        HashMap<Integer, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);
        for (int i = 0; i <n; i++) {
            names[i] =  map.get(heights[n - i -1]);
        }
        return names;
    }
}
