package medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagram {
    
    public static void main(String[] args) {
        String[] str = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(str));
        
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        
        String[] s = strs.clone();
        for (int i = 0 ; i < strs.length; i++ ) {
            strs[i]  = sortString(strs[i]);
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (int i= 0; i < strs.length; i++) {
            if (map.containsKey(strs[i])) {
                map.get(strs[i]).add(s[i]);
            }
            else {
                ArrayList<String> st = new ArrayList<>();
                st.add(s[i]);
                map.put(strs[i], st);
            }
        }

       for (ArrayList<String> list: map.values()) {
            ans.add(list);
       }
        return ans;
        
    }
    public static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}
