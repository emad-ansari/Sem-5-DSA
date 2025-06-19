package graph;
// https://leetcode.com/problems/flood-fill/
public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[][] ans = image;

        int oc = image[sr][sc];
        if (oc == color)
            return image;
        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };

        dfs(image, ans, sr, sc, color, oc, delRow, delCol);

        return ans;

    }

    public void dfs(int[][] image, int[][] ans, int r, int c, int newColor, int oc, int[] delRow, int[] delCol) {

        int m = image.length, n = image[0].length;

        ans[r][c] = newColor;

        for (int i = 0; i < 4; i++) {
            int nrow = r + delRow[i];
            int ncol = c + delCol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && image[nrow][ncol] == oc
                    && ans[nrow][ncol] != newColor) {
                dfs(image, ans, nrow, ncol, newColor, oc, delRow, delCol);
            }
        }

    }
}
