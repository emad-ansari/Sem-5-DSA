package dp;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/pascals-triangle/description/  [SOLVED]
public class PascaleTriangle {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans = new ArrayList<>();

        for (int r = 0; r < n; r++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int c = 1; c < r; c++) {
                list.add(ans.get(r - 1).get(c) + ans.get(r - 1).get(c - 1));
            }
            
            if (r !=  0) list.add(1);
            ans.add(list);
        }
        return ans;
    }
    
}
