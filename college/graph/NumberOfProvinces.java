package graph;

import java.util.ArrayList;

// https://www.geeksforgeeks.org/problems/number-of-provinces/1
public class NumberOfProvinces {
   
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // convert the graph into adj list
        ArrayList<Integer> graph[] = new ArrayList[V];
        
        for (int i = 0; i < V; i++) graph[i] = new ArrayList<>();
        
        int m = adj.size(), n = adj.get(0).size(), count = 0;
        
        for (int u = 0; u < m; u++) {
            for (int v = 0; v < n; v++) {
                if (u != v && adj.get(u).get(v) == 1) {
                    graph[u].add(v);
                }
            }
        }
        
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                count++;
                dfs(graph, i, vis);
            }
        }
        return count;
    }
    
    public static void dfs(ArrayList<Integer> graph[], int node, boolean[] vis) {
        
        vis[node] = true;
        
        for (int adj: graph[node]) {
            if (!vis[adj]) {
                dfs(graph, adj, vis);
            }
        }
    }
    
}
