package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WeightedGraph {
    List<List<Pair>> graph;
    class Pair {
        int neighbour;
        int w;
        Pair(int neighbour, int w) {
            this.neighbour = neighbour;
            this.w = w;
        }
    }
    WeightedGraph (int E) {
        graph = new ArrayList<>();
        for (int i = 0; i < E; i++) {
            this.graph.add(new ArrayList<>());
        }
    }
    public void addEdge(int u, int v, int w) {
        this.graph.get(u).add(new Pair(v, w));
        this.graph.get(v).add(new Pair(u, w));
    }
    public void printGraph() {
        
        for (int i = 0; i < this.graph.size(); i++) {
            List<Pair> adj = this.graph.get(i);
            for (int j = 0; j < adj.size(); j++) {
                System.out.print(adj.get(j).neighbour + " " + adj.get(j).w);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of edges: ");
        int E = in.nextInt();
        WeightedGraph g = new WeightedGraph(E);
        for (int i = 0; i < E; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            g.addEdge(u, v, w);
        }
        // print the grpah;
        g.printGraph();
        in.close();
        
    }
    
}
