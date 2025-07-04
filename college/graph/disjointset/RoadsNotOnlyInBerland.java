package graph.disjointset;
import java.util.*;
import java.io.*;

// https://codeforces.com/problemset/problem/25/D
public class RoadsNotOnlyInBerland  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n =  Integer.parseInt(st.nextToken());
        int[] parent = new int[n + 1];
        int[] size = new int[n + 1];
        List<List<Integer>> closeAndOpen = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (find(a, parent) == find(b, parent)) {
                // add this a, b to list
                List<Integer> road = new ArrayList<>();
                road.add(a);
                road.add(b);
                closeAndOpen.add(road);
            }
            else {
                union(a, b, parent, size);
            }
        }
        int days = closeAndOpen.size();
        int k = 0;
        for (int i = 1; i < n && k < days; i++) {
            if (find(i, parent) != find(i + 1, parent)) {
                closeAndOpen.get(k).add(i);
                closeAndOpen.get(k++).add(i + 1);
                union(i, i + 1, parent, size);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(days).append('\n');

        for (int i = 0; i < days; i++) {
            for (int j = 0; j < 4; j++) {
                sb.append(closeAndOpen.get(i).get(j)).append(" ");
            }
            sb.append('\n');
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public static void union(int u, int v, int[] parent, int[] size) {
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
    public static int find(int node, int[] parent) {
        if (node == parent[node]) return node;
        return parent[node] = find(parent[node], parent);
    }
}