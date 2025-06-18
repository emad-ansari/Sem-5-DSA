package graph;

import java.util.ArrayList;
import java.util.List;
// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1

public class UndirectedGraphCycle {
    List<List<Integer>> graph; 
    
    UndirectedGraphCycle () {
        graph = new ArrayList<>();
    }
    public boolean isCycle(int V, int[][] edges) {
        
        // Code here
        for (int i = 0; i < V; i++) {
            this.graph.add(new ArrayList<>());
        }
        
        for (int[] edge: edges) {
            addEdge(edge[0], edge[1]);
        }
        boolean[] vis = new boolean[V];
        // now apply dfs
        
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                if (dfs(i, -1, vis)) return true;
            }
        }
        return false;
    }
    public boolean dfs(int node, int p, boolean[] vis) {
        vis[node] = true;
        
        List<Integer> adj = this.graph.get(node);
        for (int i = 0; i < adj.size(); i++) {
            if (!vis[adj.get(i)]) {
                if (dfs(adj.get(i), node, vis)) return true;
            }
            else if (adj.get(i) != p) return true;
            
        }
        return false;
    }
    public void addEdge(int u, int v) {
        this.graph.get(u).add(v);
        this.graph.get(v).add(u);
    }
}
