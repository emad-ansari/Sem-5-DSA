package graph.disjointset;

// https://leetcode.com/problems/redundant-connection/

public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length, au = -1, av = -1;
        
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];

            if (find(u, parent) == find(v, parent)) {
                au = u;
                av = v;
            }
            else {
                union(u, v, parent, size);
            }
        }
        
        return new int[] {au, av};
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
    public int find(int node, int[] parent){
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node], parent);
    }
    
}
