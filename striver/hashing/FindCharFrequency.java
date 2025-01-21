package striver.hashing;

import java.util.HashMap;

public class FindCharFrequency {
    public static void main(String[] args) {
        char[] ch = {'a', 'c', 'a', 'b', 'b', 'a', 'c'};
        findCharFrequencies(ch);
    }
    public static void findCharFrequencies(char[] ch) {
        // define the Hash map
        HashMap<Character, Integer> map = new HashMap<>();
        // then pre-store the value
        for (char item : ch) {
            int value = map.get(item) != null ? map.get(item) : 0;
            map.put(item, value + 1);
        }

        // print the map
        for (char c : map.keySet()) {
            System.out.println(c + " -> " + map.get(c));
        }

    }
}
