package graph.disjointset;

import java.util.*;
import java.io.*;

public class BuildingRoad {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++)
            parent[i] = i;

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            union(u, v, parent, rank);
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (find(i, parent) == i)
                list.add(i);
        }

        int numberOfRoads = list.size() - 1;
        StringBuilder sb = new StringBuilder();
        sb.append(numberOfRoads).append('\n');

        for (int i = 1; i < list.size(); i++) {
            sb.append(list.get(i - 1) + 1).append(" ").append(list.get(i) + 1).append('\n');
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x])
            return x;

        return parent[x] = find(parent[x], parent);
    }

    public static void union(int u, int v, int[] p, int[] rank) {
        int p_u = find(u, p);
        int p_v = find(v, p);

        if (p_u == p_v)
            return;

        int rank_u = rank[p_u];
        int rank_v = rank[p_v];

        if (rank_u == rank_v) {
            p[p_u] = p_v;
            rank[p_v] += 1;
        } else if (rank_u < rank_v) {
            p[p_u] = p_v;
        } else {
            p[p_v] = p_u;
        }
    }
}