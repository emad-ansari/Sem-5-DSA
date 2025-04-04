package subsets;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class LetterCombinationOfPhoneNumber {
    public static void main(String[] args) {
        System.out.println(letterCombinations(""));
        
    }
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        List<String> res = new ArrayList<>();        
        if (digits.length() != 0) backtrack(digits, 0, map, "", res);
        return res;
    }
    public static void backtrack(String d, int i, HashMap<Character, String> map, String p, List<String> res) {
        if (i == d.length()) {
            res.add(p);
            return;
        }
        String str = map.get(d.charAt(i));
        for (int j = 0; j < str.length(); j++) {
            backtrack(d, i + 1, map, p + str.charAt(j), res);
        }
    }

}
