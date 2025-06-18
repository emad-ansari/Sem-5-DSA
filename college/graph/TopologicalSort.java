package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
// https://www.geeksforgeeks.org/problems/topological-sort/1
public class TopologicalSort {
     public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
         
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        
        int E = edges.length;
        
        for (int i = 0; i < E; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
        }
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        int[] indegree = new int[V];
        
        for (int[] edge: edges) {
            indegree[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        // put all node which indegree is 0 in to queue
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);
            
            for(int adj: graph.get(node)) {
                indegree[adj]--;
                if (indegree[adj] == 0) {
                    q.add(adj);
                }
            }
            
        }
        return ans;
    }
    
}
