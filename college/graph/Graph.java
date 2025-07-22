package graph;
import java.util.Arrays;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Graph {
    static class Pair {
        int r, c;
        Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
        
    }
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();

        int E = input.nextInt();

        int[][] edges = new int[E][2];

        for (int i = 0; i < edges.length; i++) {
            edges[i][0] = input.nextInt();
            edges[i][1] = input.nextInt();
        }

        // Adjcency matrix  
        int[][] adjMat = new int[n + 1][n + 1];
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adjMat[u][v] = 1;
            adjMat[v][u] = 1;
        }

        // print matrix

        for (int[] mat: adjMat) {
            System.out.println(Arrays.toString(mat));
        }

        // now adjcency list

        List<List<Integer>> graph = new ArrayList<>();

        for (int[] edge: edges) {
            addEdge(graph, edge[0], edge[1]);
        }

        // print list
        for (List<Integer> list: graph) {
            System.out.println(list);
        }
    
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        input.close();
    }

    public static void addEdge (List<List<Integer>> graph, int u, int v) {
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    public static List<Integer> bfs(List<List<Integer>> graph, int node) {
        List<Integer> ans = new ArrayList<>();
        int V = graph.size();

        boolean[] vis = new boolean[V + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        
        
        while (!q.isEmpty()) {
            int currentNode = q.poll();
            ans.add(currentNode);
            
            for (int adj: graph.get(currentNode)) {
                if (!vis[adj]) {
                    vis[adj] = true;
                    q.add(adj);
                }
            }
        }
        return ans;
    }

    
    public static List<Pair> dfsOnMatrix(int[][] graph, int r, int c, int[] delRow, int[] delCol) {
        int n = graph.length;
        List<Pair> ans = new ArrayList<>();

        boolean[][] vis = new boolean[n][n];

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(r, c));

        while (!q.isEmpty()) {
            int row = q.peek().r;
            int col = q.peek().c;
            ans.add(q.poll());
            

            for (int i = 0; i < 4; i++) {
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && graph[nrow][ncol] == 1 && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
            
        }

        return ans;

    }
}
