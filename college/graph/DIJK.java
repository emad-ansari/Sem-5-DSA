package graph;

import java.util.*;

public class DIJK {
    static class Pair {
        int node, w;

        Pair(int node, int w) {
            this.node = node;
            this.w = w;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int V = input.nextInt();
        int E = input.nextInt();
        int src = input.nextInt();

        List<List<Pair>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            List<Pair> adjList = new ArrayList<>();
            graph.add(adjList);
        }

        for (int i = 0; i < E; i++) {
            int u = input.nextInt();
            int v = input.nextInt();
            int w = input.nextInt();
            graph.get(u).add(new Pair(v, w));
            graph.get(v).add(new Pair(u, w));
        }
        
        int[] ans = dijkstra(graph, V, src);
        System.out.println(Arrays.toString(ans));


        input.close();

    }


    public static int[] dijkstra(List<List<Pair>> graph, int V, int src) {

        int[] dist = new int[V];
        Arrays.fill(dist, (int) (1e9));
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.w - b.w);

        pq.offer(new Pair(src, 0));

        while (!pq.isEmpty()) {
            int currentNode = pq.peek().node;
            int cost = pq.peek().w;
            pq.poll();

            for (Pair adj : graph.get(currentNode)) {
                int adjNode = adj.node;
                int adjWeight = adj.w;

                if (cost + adjWeight < dist[adjNode]) {
                    dist[adjNode] = cost + adjWeight;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }

            }

        }
        return dist;
    }

}
