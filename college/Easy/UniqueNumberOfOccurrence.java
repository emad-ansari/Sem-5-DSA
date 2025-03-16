package Easy;

import java.util.HashMap;
import java.util.HashSet;



// https://leetcode.com/problems/unique-number-of-occurrences/description/  [SOLVED]


public class UniqueNumberOfOccurrence {
    public static void main(String[] args) {
        int[] arr = {1,2,2,1,1,3};
        int[] arr1  ={1,2};
        int[] arr2 = {-3,0,1,-3,1,1,1,-3,10,0};

        System.out.println(uniqueOccurrences1(arr));
        System.out.println(uniqueOccurrences1(arr1));
        System.out.println(uniqueOccurrences1(arr2));

    }


    public static  boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : arr)
            map.put(num, map.getOrDefault(num, 0) + 1);

        HashSet<Integer> set = new HashSet<>();
        for (int key: map.keySet()) {
            set.add(map.get(key));
        }
        return map.size() == set.size();

    }
    public static  boolean uniqueOccurrences1(int[] arr) {
        int[] freq = new int[2001];
        for (int num: arr) freq[num + 1000]++;

        boolean[] repeated = new boolean[2001];
        for (int num: arr) {
            int cf = freq[num + 1000];
            if (cf > 0 && repeated[cf]) return false;
            freq[num + 1000] = 0;
            repeated[cf] = true;

        }
        return true;
    }
}
