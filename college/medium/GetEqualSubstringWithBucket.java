package medium;
//https://leetcode.com/problems/get-equal-substrings-within-budget/description/
public class GetEqualSubstringWithBucket {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        System.out.println(equalSubstring(s, t, 3));
        
    }

    public static int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0, cost = 0, maxl = 0;
        char[] sc = s.toCharArray();
        char[] tc = t.toCharArray();
        while (r < sc.length){
            cost += Math.abs(sc[r] - tc[r]);
            while (cost > maxCost) {
                cost -= Math.abs(sc[l] - tc[l]);
                l++;
            }
            maxl = Math.max(maxl, r- l + 1);
            r++;
        }
        return maxl;

    }

}
