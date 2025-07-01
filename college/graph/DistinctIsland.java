package graph;

import java.util.HashSet;
import java.util.Set;
// https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
public class DistinctIsland {
    public static void main(String[] args) {
        int[][] grid = { 
            { 1, 1, 0, 0, 0 },
            { 1, 1, 0, 0, 0 },
            { 0, 0, 0, 1, 1 },
            { 0, 0, 0, 1, 1 }
        };

        System.out.println("Number of distinct island: " + countDistinctIslands(grid));
    }

    public static int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length, m = grid[0].length;

        int[] delRow = { -1, 0, +1, 0 };
        int[] delCol = { 0, +1, 0, -1 };

        String[] dir = { "U", "R", "D", "L" };

        boolean[][] vis = new boolean[n][m];
        Set<String> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    String path = dfs(grid, i, j, vis, delRow, delCol, dir, "S");
                    set.add(path);
                }
            }
        }

        return set.size();

    }

    public static String dfs(int[][] grid, int r, int c, boolean[][] vis, int[] delRow, int[] delCol, String[] dir,
            String path) {
        int n = grid.length, m = grid[r].length;

        vis[r][c] = true;
        StringBuilder sb = new StringBuilder();
        sb.append(path);

        for (int i = 0; i < 4; i++) {
            int nrow = r + delRow[i];
            int ncol = c + delCol[i];

            if (isSafe(nrow, ncol, n, m) && grid[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                sb.append(dfs(grid, nrow, ncol, vis, delRow, delCol, dir, path + dir[i]));
            }
        }

        sb.append("B");
        return sb.toString();

    }

    public static boolean isSafe(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }

}
