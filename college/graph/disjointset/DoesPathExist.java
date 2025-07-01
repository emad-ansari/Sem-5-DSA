package graph.disjointset;

// https://leetcode.com/problems/find-if-path-exists-in-graph/ 
public class DoesPathExist {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        int[] p = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i;
        }

        for (int[] edge: edges) {
            union(edge[0], edge[1], p, rank);
        }

        return find(source, p) == find(destination, p);
    }

    public int find(int x, int[] parent) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x], parent);
    }

    public void union(int u, int v, int [] p, int[] rank) {
        int p_u = find(u, p);
        int p_v = find(v, p);

        if (p_u == p_v) return;

        int rank_u = rank[p_u];
        int rank_v = rank[p_v];

        if (rank_u == rank_v) {
            p[p_u] = p_v;
            rank[p_v] += 1;
        }
        else if (rank_u < rank_v) {
            p[p_u] = p_v;
        }
        else {
            p[p_v] = p_u;
        }
    }
    
}
