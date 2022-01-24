package programmers.level2;

import java.util.*;

public class DivideThePowerGridIntoTwo {    // 3페이지 & 전령망을 둘로 나누기
    public static void main(String[] args) {
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        System.out.println(solution(9, wires));
    }
    static int[][] arr;
    public static int solution(int n, int[][] wires) {
        int answer = n;
        arr = new int[n + 1][n + 1];

        // 인접 행렬에 input
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        // 선을 하나씩 끊어보면서 순회
        int a, b;
        for (int i = 0; i < wires.length; i++) {
            a = wires[i][0];
            b = wires[i][1];

            // 선 하나 끊기
            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, bfs(n, a));

            // 선 다시 복구
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        return answer;
    }

    public static int bfs(int n, int start) {
        int[] visit = new int[n + 1];
        int cnt = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {
            int point = q.poll();
            visit[point] = 1;

            for (int i = 1; i <= n; i++) {  // point와 연결된 애들 중에 방문한적 없는 노드 전부 큐에 넣기
                if (visit[i]==1) continue;
                if (arr[point][i] == 1) {
                    q.offer(i);
                    cnt++;
                }
            }
        }
        return (int) Math.abs(n - 2 * cnt);
    }
}
