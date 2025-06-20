package graph;

// https://leetcode.com/problems/detect-cycles-in-2d-grid/
public class DetectCycleIn2DGrid {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (dfs(grid, i, j, -1, -1, vis, delRow, delCol)) return true;
                }
            }
        }

        return false;
    }

    public boolean dfs (char[][] grid, int r, int c, int pr, int pc, boolean[][] vis, int[] delRow, int[] delCol) {

        vis[r][c] = true;

        int m = grid.length, n = grid[r].length;

        for (int i = 0; i < 4; i++) {
            int nrow = r + delRow[i];
            int ncol = c + delCol[i];

            if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n &&  grid[nrow][ncol] == grid[r][c]) {
                if (!vis[nrow][ncol]) {
                    if (dfs(grid, nrow, ncol, r, c, vis, delRow, delCol)) return true;
                }
                else if (nrow != pr && ncol != pc) {
                    return true;
                }

            }
          
        }
        return false;
    }
}
