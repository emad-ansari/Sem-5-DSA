package greedy;

import java.util.Arrays;

public class AssignCookies {
    
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0, count = 0, m = g.length, n = s.length;
        while (i < m && j < n) {
            if (s[j] >= g[i]) {
                count++;
                i++;
            }
            j++;
        }
        return count;
    }

}
