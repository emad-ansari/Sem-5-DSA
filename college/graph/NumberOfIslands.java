package graph;
// https://www.geeksforgeeks.org/problems/find-the-number-of-islands/1

public class NumberOfIslands {
    public int countIslands(char[][] grid) {
        // Code here
        int m = grid.length, n = grid[0].length, count = 0;

        boolean[][] vis = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && grid[i][j] == 'L') {
                    count++;
                    dfs(grid, i, j, vis);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] graph, int i, int j, boolean[][] vis) {

        if (i < 0 || i == graph.length || j < 0 || j == graph[i].length)
            return;
        if (graph[i][j] == 'W')
            return;

        vis[i][j] = true;

        if (i > 0 && !vis[i - 1][j])
            dfs(graph, i - 1, j, vis);

        if (i < graph.length - 1 && !vis[i + 1][j])
            dfs(graph, i + 1, j, vis);

        if (j > 0 && !vis[i][j - 1])
            dfs(graph, i, j - 1, vis);

        if (j < graph[i].length - 1 && !vis[i][j + 1])
            dfs(graph, i, j + 1, vis);

        if (i > 0 && j > 0 && !vis[i - 1][j - 1])
            dfs(graph, i - 1, j - 1, vis);

        if (i > 0 && j < graph[i].length - 1 && !vis[i - 1][j + 1]) {
            dfs(graph, i - 1, j + 1, vis);
        }

        if (i < graph.length - 1 && j > 0 && !vis[i + 1][j - 1]) {
            dfs(graph, i + 1, j - 1, vis);
        }

        if (i < graph.length - 1 && j < graph[i].length - 1 && !vis[i + 1][j + 1]) {
            dfs(graph, i + 1, j + 1, vis);
        }
    }

}
