package trie;

import java.util.Scanner;

public class DistinctRowsInBinaryMatrix {
    class TrieNode {
        TrieNode[] arr;
        TrieNode () {
            arr = new TrieNode[2];
        }
    }
    TrieNode root;
    DistinctRowsInBinaryMatrix() {
        root = new TrieNode();
    }

    public boolean insert(TrieNode root, int[] nums) {
        boolean flag = false;
        TrieNode temp = root;
        for (int i = 0; i < nums.length; i++) {
            if (temp.arr[nums[i]] == null) {
                flag = true;
                temp.arr[nums[i]] = new TrieNode();
            }
            temp = temp.arr[nums[i]];
        }
        return flag;
    }
    public  int countDistinctRows(int[][] mat) {
        int cnt = 0;
        for (int[] nums: mat) {
            if (insert(root, nums)) cnt++;
        }
        return cnt;
    }
    public static void main (String[] args ) {
        Scanner input = new Scanner (System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] mat  = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = input.nextInt();
            }
        }
        DistinctRowsInBinaryMatrix t = new DistinctRowsInBinaryMatrix();
        System.out.println(t.countDistinctRows(mat));
        input.close();
    }
}
