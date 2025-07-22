package graph.disjointset;
import java.util.*;
import java.io.*;

public class HWI7  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(st.nextToken());

        int[] parent  = new int[n + 1];
        int[] rank = new int[n + 1];

        Map<Integer, TreeSet<Integer>> map = new HashMap<>();

        int[] beautyMap = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i;
            TreeSet<Integer> set = new TreeSet<>();
            rank[i] = 0;
            set.add(i);
            map.put(i, set);            
            beautyMap[i] = 1;
        }
        int totalBeauty = 0;
        while (q-- != 0) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type == 1) {
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int newRoot = union(u, v, parent, rank);

                if (newRoot !=  -1) {
                    for (int item: map.get(u)) {
                        TreeSet<Integer> pset = map.get(newRoot);

                        if (pset.contains(item  + 1) && pset.contains(item - 1)) {
                            beautyMap[newRoot]--;
                        }
                        if (!pset.contains(item  + 1) && !pset.contains(item - 1))  beautyMap[newRoot]++;
                        pset.add(item);
                    }
                }

            }
            else {
                int u = Integer.parseInt(st.nextToken());
                int pu  = find(u, parent);
                int beauty = beautyMap[pu];
                totalBeauty += beauty;
            }

        }
        bw.write(Integer.toString(totalBeauty));

        bw.flush();
        bw.close();
    }

    public static int find(int x, int[] parent) {
        if (x == parent[x]) return x;

        return parent[x] = find (parent[x], parent);
    }

    public static int union(int u, int v, int[] parent, int[] rank) {
        int pu = find(u, parent);
        int pv = find(v, parent);

        if (pu != pv) {
            int ru = rank[u];
            int rv = rank[v];

            if (ru == rv) {
                parent[pu] = pv;
                rank[pv] += 1;
                return pv;
            }
            else if (ru < rv) {
                parent[pu] = pv;    
                return pv;
            }
            else {
                parent[pv] = pu;
                return pu;
            }
        }
        return -1;
    }
}