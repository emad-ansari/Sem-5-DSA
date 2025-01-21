package striver.hashing;

import java.util.HashMap;

public class FindNumberFrequency {
    public static void main(String[] args) {
        int[] arr =  {1, 2, 1, 3, 2, 1, 3, 4};
        findFrequencies(arr);


    }
    public static void findFrequencies(int[] arr) {
        // use hashmap to find the frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int j : arr) {
            int item = map.get(j) != null ? map.get(j) : 0;
            map.put(j, item + 1);
        }
        // print the map
        for (int key: map.keySet()) {
            System.out.println(key + " -> " + map.get(key));
        }
    }
}
