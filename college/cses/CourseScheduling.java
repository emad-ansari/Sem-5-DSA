package cses;
import java.util.*;
import java.io.*;

public class CourseScheduling  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n + 1];

        List<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        StringBuilder sb = new StringBuilder();
        int count = 0;

        while (!q.isEmpty()) {
            int c = q.poll();
            sb.append(c).append(" ");
            count++;

            for (int adj: graph[c]) {
                indegree[adj]--;
                if (indegree[adj] == 0){
                    q.add(adj);
                }
            }
        }

        if (count !=  n) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        bw.write(sb.toString());

        bw.flush();
        bw.close();
    }
}