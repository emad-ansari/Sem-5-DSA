package graph.dijkastra;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
// https://leetcode.com/problems/shortest-path-in-binary-matrix/ 

public class ShortestPathInBinaryMatrix {
     public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == 0) return 1;
        
        int[][] dist = new int[n][n];
        boolean[][] vis = new boolean[n][n];
        int[] delRow = {-1, -1, 0, +1, +1, +1, 0, -1};
        int[] delCol = {0, +1, +1, +1, 0, -1, -1, -1};
        
        for (int[] arr: dist) {
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][0] = 1;
        
        Deque<Pair> q = new ArrayDeque<>(); 
        
        q.add(new Pair(0, 0, 1));
        
        while (!q.isEmpty()) {
            int r = q.getFirst().r;
            int c = q.getFirst().c;
            int w = q.getFirst().w;
            
            vis[r][c] = true;
            q.pollFirst();
            
            for (int i = 0; i < 8; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                
                if (isSafe(n, nrow, ncol) && !vis[nrow][ncol] && grid[nrow][ncol] == 0) {
                    if (w + 1 < dist[nrow][ncol]) {
                        dist[nrow][ncol] = w + 1;
                        if (nrow == n - 1 && ncol == n - 1) return dist[nrow][ncol];
                        q.add(new Pair(nrow, ncol, dist[nrow][ncol]));
                    }
                }
            }
            
        }
        
        
        return -1;
    }

    public boolean isSafe(int n, int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
    
}

class Pair {
    int r, c, w;
    Pair(int r, int c, int w){
        this.r = r;
        this.c = c;
        this.w = w;
    }
}
