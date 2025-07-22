package graph.disjointset;
import java.util.Scanner;
public class DisjointSet {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];

        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }

        int q = input.nextInt();
        while (q-- != 0) {
            int u = input.nextInt();
            int v = input.nextInt();
            unionBySize(u, v, parent, size);
        }

        input.close();
    }

    public static void unionBySize(int u, int v, int[] parent, int[] size) {
        int pu = find(u, parent);
        int pv = find(v, parent);

        if (pu == pv) return;

        int su = size[pu];
        int sv = size[pv];

        if (su <= sv) {
            parent[pu] = pv;
            size[pv] += size[pu];
        }
        else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        
    }
    public static int find(int u, int[] parent) {
        if (u == parent[u]) return u;

        return parent[u] = find (parent[u], parent);
    }


    
}
