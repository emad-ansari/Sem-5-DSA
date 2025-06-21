package rangequery;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ForestQueries {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int q = Integer.parseInt(input[1]);
            int[][] trees = new int[n][n];

            for (int i = 0; i < n; i++) {

                char[] ch = br.readLine().toCharArray(); 
                for (int j = 0; j < n; j++) {
                    if (ch[j] == '*') trees[i][j] = 1;
                }
            }
            // preprocess the tree arrray
            int[][] pref = new int[n][n];

            pref[0][0] = trees[0][0];
            for (int j = 1; j < n; j++) {
                pref[0][j] = trees[0][j] + pref[0][j - 1];
            }
            for (int i = 1; i < n; i++) {
                pref[i][0] = trees[i][0] + pref[i - 1][0];
            }

            for (int i = 1; i < n; i++) {
                for (int j = 1; j < n; j++) {
                    pref[i][j] = trees[i][j] + pref[i - 1][j] + pref[i][j - 1] - pref[i - 1][j - 1];
                }
            }
            while (q-- != 0) {
                String[] range = br.readLine().split(" ");
                int y1 = Integer.parseInt(range[0]);
                int x1 = Integer.parseInt(range[1]);
                int y2 = Integer.parseInt(range[2]);
                int x2 = Integer.parseInt(range[3]);

                int ans = rangeQuery(pref, y1 - 1, x1 - 1, y2 - 1, x2 - 1);
                bw.write(Integer.toString(ans));
                bw.newLine();
                bw.flush();
            }
        }
    }

    public static int rangeQuery(int[][] pref, int r1, int c1, int r2, int c2) {
        int ls = c1 == 0 ? 0 : pref[r2][c1 - 1];
        int us = r1 == 0 ? 0 : pref[r1 - 1][c2];
        int cs = r1 == 0 || c1 == 0 ? 0 : pref[r1 - 1][c1 - 1];
        return pref[r2][c2] - ls - us + cs;
    }
}
