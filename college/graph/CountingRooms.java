package graph;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class CountingRooms {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);

            char[][] graph = new char[m][n];
            for (int i = 0; i < m; i++) {
                char[] ch = br.readLine().toCharArray();
                graph[i] = ch;
            }

            boolean[][] vis = new boolean[m][n];
            int[] delRow = {-1, 0, + 1, 0};
            int[] delCol = {0, +1, 0, -1};
            int room = 0;

            for (int i =0; i < m; i++)  {
                for (int j = 0; j < n; j++) {
                    if (!vis[i][j] && graph[i][j] == '.') {
                        room ++;
                        dfs(graph, i, j, vis, delRow, delCol);
                    }
                }
            }
            bw.write(Integer.toString(room));
            bw.newLine();
            bw.flush();
        }

    }

    public static void dfs(char[][] graph, int row, int col, boolean[][] vis, int[] delRow, int[] delCol) {
        int m  =  graph.length, n = graph[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});
        vis[row][col] = true;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nrow = r + delRow[i];
                int ncol = c + delCol[i];

                if (nrow >= 0 && nrow < m && ncol >= 0 && ncol < n
                        && graph[nrow][ncol] == '.' && !vis[nrow][ncol]) {
                    vis[nrow][ncol] = true;
                    stack.push(new int[]{nrow, ncol});
                }
            }
        }
    }
    
}
