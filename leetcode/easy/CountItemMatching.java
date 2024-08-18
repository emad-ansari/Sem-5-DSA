package leetcode.easy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/count-items-matching-a-rule/ [SOLVED]

public class CountItemMatching {
    public static void main(String[] args) {
        String[][] array = {{"phone","blue","pixel"},{"computer","silver","phone"},{"phone","gold","iphone"}};
        List<List<String>> items = new ArrayList<>();
        for (String[] item : array) {
            items.add(Arrays.asList(item));
        }

        System.out.println((items));


        System.out.println("ans: " + countMatches(items, "type", "phone"));


    }
    public static int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        if (items.size() == 1){
            if (isItemMatches(items.getFirst(), ruleKey, ruleValue)){
                return 1;
            }
            return 0;
        }
        int count = 0;
        for (List<String> item: items){
            if (isItemMatches(item, ruleKey, ruleValue)){
                count += 1;
            }
        }
        return count;

    }
    public static boolean isItemMatches(List<String> item, String ruleKey, String ruleValue){
        if (ruleKey.equals("type") && item.get(0).equals(ruleValue) ){
            return true;
        }
        if (ruleKey.equals("color") && item.get(1).equals(ruleValue)){
            return true;
        }
        return ruleKey.equals("name") && item.get(2).equals(ruleValue);
    }
}
