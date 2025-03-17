package Easy;

import java.util.HashMap;

// https://leetcode.com/problems/kth-distinct-string-in-an-array/description/  [SOLVED]

public class KThDistinctElement {

    public static void main(String[] args) {
        
    }
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        for (String s: arr) map.put(s, map.getOrDefault(s, 0) + 1);
        int cnt = 0;
        for (String s: arr) {
            if (map.get(s) == 1) {
                cnt++;
                if (cnt == k) return s;
            }
        }
        return "";
    }
}
