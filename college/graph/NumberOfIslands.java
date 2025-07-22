package graph;
// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

public class NumberOfIslands {
    public int countIslands(char[][] grid) {
        // Code here
        int m = grid.length, n = grid[0].length, count = 0;
        int[] delRow = {-1, -1, 0, +1, +1, +1, 0, -1};
        int[] delCol = {0, +1, +1, +1, 0, -1, -1, -1};

        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 'L') {
                    count++;
                    dfs(grid, i, j, vis, delRow, delCol);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] graph, int r, int c, boolean[][] vis, int[] delRow, int[] delCol) {
        int m  = graph.length, n = graph[0].length;

        vis[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nrow = r + delRow[i];
            int ncol = c + delCol[i];

            if (isSafe(m, n, nrow, ncol) && graph[nrow][ncol] == 'L' && !vis[nrow][ncol]) {
                dfs(graph, nrow, ncol, vis, delRow, delCol);
            }
        }
    }
    public  boolean isSafe(int n, int m, int r, int c) {
        return r >= 0 && r < m && c >= 0 && c < n;
    }

}
