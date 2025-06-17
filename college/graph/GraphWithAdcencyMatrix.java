package graph;
import java.util.Scanner;
public class GraphWithAdcencyMatrix {
    int[][] graph;
    GraphWithAdcencyMatrix (int E, int V) {
        graph = new int[V][V];
    }
    
    public void addEdge(int u, int v) {
        this.graph[u][v] = 1;
        this.graph[v][u] = 1;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number of nodes: ");
        int V = in.nextInt();
        in.nextLine();
        System.out.print("Enter the number of edges: ");
        int E = in.nextInt();
        GraphWithAdcencyMatrix g = new GraphWithAdcencyMatrix(E, V);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge( 1, 3);
        g.addEdge(2, 3);
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(g.graph[i][j] + " ");
            }
            System.out.println();
        }
        in.close();
    }
    
  
   
}
