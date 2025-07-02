package graph.disjointset;

// https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1  

public class DetectCycleInUnidrectedGraph {


    public boolean isCycle(int V, int[][] edges) {
        
        int[] parent = new int[V];
        int[] size = new int[V];
        
        for (int i = 0; i < V; i++) {
            size[i] = 1;
            parent[i] = i;
        }
        
        for (int[] edge: edges) {
            if (find(edge[0], parent) == find(edge[1], parent)) return true;
            union(edge[0], edge[1], parent, size);
        }
        return false;
    }

    public void union(int u, int v, int[] parent, int[] size) {
        int pu = find(u, parent);
        int pv = find(v, parent);
        
        if (size[pu] <= size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
    public int find(int node, int[] parent) {
        if (node == parent[node]) return node;
        
        return parent[node] = find(parent[node], parent);
    }
    
}
