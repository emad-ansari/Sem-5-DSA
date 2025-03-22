package medium;

// https://leetcode.com/problems/spiral-matrix-iv/description/ [SOLVED]
public class SpiralMatrix4 {
    public class ListNode {
        int val;
        ListNode next;
    }
    public static void main(String[] args) {
        
    }
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        if (head == null) return new int[][]{};
        ListNode node = head;
        int[][] res = new int[m][n];

        int fr = 0, lr = m - 1, fc = 0, lc = n - 1;
        while (fr <= lr && fc <= lc) {
            // first row
            for (int i = fc; i <= lc; i++) {
                res[fr][i] = node == null ? -1 : node.val;
                if (node != null) node = node.next;
            }

            // last column
            for (int i = fr + 1; i <= lr; i++) {
                res[i][lc] = node == null ? -1 : node.val;
                if (node != null) node = node.next;
            }

            // last row
            if (fr != lr) {
                for (int i = lc - 1; i >= fc; i--) {
                    res[lr][i] =  node == null ? -1 : node.val;
                    if (node != null) node = node.next;
                }
            }

            // first col
            if (fc != lc) {
                for (int i = lr - 1; i > fr; i--) {
                    res[i][fc] =  node == null ? -1 : node.val;
                    if (node != null) node = node.next;
                }
            }
            fr++;
            lr--;
            fc++;
            lc--;
        }

        return res;
    }
    

}
