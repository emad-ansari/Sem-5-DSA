package graph;

import java.util.LinkedList;
import java.util.Queue;
// https://www.geeksforgeeks.org/problems/rotten-oranges2536/1

public class RottenOranges {
    class Pair {
        int r, c, t;
        Pair (int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
        
    }
    
    public int orangesRotting(int[][] mat) {
        // Code here

        int m = mat.length, n = mat[0].length;
        boolean[][] vis = new boolean[m][n];
        
        int[] delRow = {-1, 0, +1, 0};
        int[] delCol = {0, +1, 0, -1};
        
        Queue<Pair> q = new LinkedList<>();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        
        int minTime = 0;
        
        while (!q.isEmpty()) {
            int r = q.peek().r;
            int c = q.peek().c;
            int t = q.peek().t;
            minTime = Math.max(t, minTime);
            q.poll();
            
            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];
                
                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && !vis[nrow][ncol] && mat[nrow][ncol] == 1) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol, t + 1));
                }
            }
            
        }
        
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j] && mat[i][j] == 1) return -1;
            }
        }
        return minTime;
    }
   
    
    
}
