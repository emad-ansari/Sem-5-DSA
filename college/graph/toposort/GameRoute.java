package graph.toposort;

import java.util.*;
import java.io.*;

public class GameRoute  {
    static final int MOD = (int)1e9 + 7;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Integer>[] graph = new ArrayList[n + 1];
        int[] indeg = new int[n + 1];

        for (int i = 0; i <=n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            indeg[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indeg[i] == 0) q.add(i);
        }
        List<Integer> topo = new ArrayList<>();
        
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int adj: graph[node]) {   
                indeg[adj]--;
                if (indeg[adj] == 0) q.add(adj);
            }  
        }

        // now apply dp
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int u: topo) {
            for (int v: graph[u]) {
                dp[v] = (dp[u] + dp[v]) % MOD; 
            }
        }
        bw.write(Integer.toString(dp[n]));
        bw.flush();
        bw.close();
    }
}
