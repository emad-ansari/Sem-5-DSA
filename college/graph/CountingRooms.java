package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingRooms {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] input = br.readLine().split(" ");
            int r = Integer.parseInt(input[0]);
            int c = Integer.parseInt(input[1]);

            char[][] graph = new char[r][c];
            for (int i = 0; i < r; i++) {
                char[] ch = br.readLine().toCharArray();
                graph[i] = ch;
            }
        }

        
    }
    
}
