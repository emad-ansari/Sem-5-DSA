package graph.dijkastra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

// https://www.geeksforgeeks.org/problems/shortest-path-in-weighted-undirected-graph/1
public class ShortesPathInUndirectedGraph {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++){
            List<Pair> adjList = new ArrayList<>();
            graph.add(adjList);
        }
        
        for (int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        
        return getShortestPath(graph, n);
        
    }
    
    public List<Integer> getShortestPath(List<List<Pair>> graph, int V) {
        int[] dist = new int[V + 1];
        int[] parent = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[1] = 0;
        parent[1] = -1;
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
        
        pq.offer(new Pair(1, 0));
        
        while (!pq.isEmpty()) {
            int currentNode = pq.peek().node;
            int currentWeight  = pq.peek().w;
            
            pq.poll();
            
            for (Pair adj: graph.get(currentNode)) {
                int adjNode = adj.node;
                int adjWeight = adj.w;
                
                if (currentWeight + adjWeight < dist[adjNode]) {
                    dist[adjNode] = currentWeight + adjWeight;
                    parent[adjNode] = currentNode;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        
        // now we have the shortes path, 
        List<Integer> res = new ArrayList<>();
        if (dist[V] == Integer.MAX_VALUE) {
            res.add(-1);
            return res;
        }
        
        List<Integer> path = new ArrayList<>();
        int k = V;
        while(k != -1) {
            path.add(k);
            k = parent[k];
            
        }
        Collections.reverse(path);
        
        res.add(dist[V]);
        res.addAll(path);
        
        return res;
        
    }
    
}
class Pair {
    int node, w;
    Pair(int node, int w) {
        this.node = node;
        this.w = w;
    }
}