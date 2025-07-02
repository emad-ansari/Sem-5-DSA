package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/ 

public class CoursesSchedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];

        if (prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) order[i] = numCourses - i - 1;
            return order;
        }

        int[] indegree = new int[numCourses];

        List<Integer>[] graph  = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();

        for (int[] edge: prerequisites) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            indegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }
        int k = numCourses -1, cnt = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            order[k--] = node;
            cnt++;
            for (int adj: graph[node]) {
                indegree[adj]--;
                if (indegree[adj] == 0) q.add(adj);
            }
        }

        return cnt == numCourses ? order : new int[] {};
    }
}
