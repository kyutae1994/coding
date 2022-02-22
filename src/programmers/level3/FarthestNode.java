package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class FarthestNode { // 1페이지 & 가장 먼 노드

    public static void main(String[] args) {
        int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        System.out.println(solution(6, edge));
    }

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[] check = new boolean[n];
        boolean[][] connect = new boolean[n][n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < edge.length; i++) {
            connect[edge[i][0] - 1][edge[i][1] - 1] = true;
            connect[edge[i][1] - 1][edge[i][0] - 1] = true;
        }
        check[0] = true;
        q.add(0);

        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                int node = q.poll();
                for (int j = 0; j < n; j++) {
                    if (connect[j][node] && !check[j]) {
                        check[j] = true;
                        q.add(j);
                    }
                }
            }
            answer = qSize;
        }
        return answer;
    }
}
