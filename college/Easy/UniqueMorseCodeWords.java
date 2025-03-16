package Easy;

import java.util.HashSet;
// https://leetcode.com/problems/unique-morse-code-words/description/  [SOLVED]

public class UniqueMorseCodeWords {
    public static void main(String[] args) {
        
        

    }
    public int uniqueMorseRepresentations(String[] words) {
        String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        HashSet<String> set = new HashSet<>();

        for (String s: words) {
            set.add(transform(s, code));
        }
        return set.size();  

    }
    public static String transform(String s, String[] code) {
        StringBuilder  t = new StringBuilder();
        for (char c: s.toCharArray()) {
            t.append(code[ c- 'a']);
        }
        return t.toString();

    }
}
