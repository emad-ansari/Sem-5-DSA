package Easy;

import java.util.List;
import java.util.ArrayList;

// https://leetcode.com/problems/find-common-characters/description/  [SOLVED]
public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        String[] words1 = { "cool", "lock", "cook" };

        System.out.println(commonChars(words));

    }

    public static List<String> commonChars(String[] words) {
        List<String> cc = new ArrayList<>();

        String fw = words[0];
        int[] map = count(fw);
        for (int i = 1; i < words.length; i++) {
            common(map, count(words[i]));
        }
        for (int i = 0; i < map.length; i++) {
            while (map[i] > 0) {
                cc.add((Character.toString(i + 'a')));
                map[i]--;
            }
        }
        return cc;
    }

    public static int[] count(String s) {
        int[] f = new int[26];
        for (char c : s.toCharArray())
            f[c - 'a']++;
        return f;
    }

    public static void common(int[] fwf, int[] swf) {
        for (int i = 0; i < fwf.length; i++) {
            fwf[i] = Math.min(fwf[i], swf[i]);
        }
    }
}
