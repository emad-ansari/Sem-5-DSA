package graph;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphAdjacencyList {
    List<List<Integer>> graph;
    GraphAdjacencyList (int E) {
        graph = new ArrayList<>();
        for (int i = 0; i <= E; i++) {
            this.graph.add(new ArrayList<>());
        }

    }
    public void bfs(int V, int s) {
        boolean[] visited = new boolean[V + 1]; // for 1 based indexing
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty())  {
            int node = q.poll();
            System.out.print(node + " ");
            List<Integer> adj = this.graph.get(node);
            for (int i = 0; i < adj.size(); i++ ) {
                if (!visited[adj.get(i)]) {
                    q.add(adj.get(i));
                    visited[adj.get(i)] = true;
                }
            }
        }
    }

    public void addEdge(int u, int v) {
        this.graph.get(u).add(v);
        this.graph.get(v).add(u);
    }
    public void printGraph() {
        System.out.println(this.graph);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int V = in.nextInt();
        System.out.print("Enter the number of edges: ");
        int E = in.nextInt();
        GraphAdjacencyList g = new GraphAdjacencyList(E);
        for (int i = 0; i < E; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g.addEdge(u, v);
        }
        // print the grpah;
        g.printGraph();
        g.bfs(V, 1);
        in.close(); 
    }
}
