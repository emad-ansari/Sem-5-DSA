package graph.dijkastra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/network-delay-time/description/
public class NetworkDelay {
     public int networkDelayTime(int[][] times, int n, int k) {
        
        List<GraphNode>[] graph = new ArrayList[n + 1];
        int E = times.length;
        for (int i = 0; i < graph.length; i++) {
            ArrayList<GraphNode> list = new ArrayList<>();
            graph[i] = list;
        }

        for (int i = 0; i < E; i++) {
            int u = times[i][0];
            int v = times[i][1];
            int cost = times[i][2];
            graph[u].add(new GraphNode(v, cost));
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        

        int[] ans = dijkastra(graph, dist, k);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (ans[i] == Integer.MAX_VALUE) return -1;
            else max = Math.max(max, ans[i]);
        }
        return max;

    }

    public  int[] dijkastra(List<GraphNode>[] graph, int[] dist, int k) {
        PriorityQueue<GraphNode> pq = new PriorityQueue<>(new Comparator<GraphNode>() {
            @Override
            public int compare(GraphNode a, GraphNode b) {
                return Integer.compare(a.cost, b.cost);
            }
        });
        pq.offer(new GraphNode(k, 0));

        while (!pq.isEmpty()) {
            GraphNode node = pq.poll();
            int u = node.node;
            for (GraphNode adj: graph[u]) {
                int v = adj.node;
                int c = adj.cost;
                if (dist[v] > dist[u] + c) {
                    dist[v] = dist[u] + c;
                    pq.offer(new GraphNode(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
class GraphNode {
    int node, cost;
    GraphNode(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
}