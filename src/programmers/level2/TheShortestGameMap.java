package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class TheShortestGameMap {
    public static void main(String[] args) {
        int[][] maps = {{1,0,1,1,1},{1,0,1,0,1},{1,0,1,1,1},{1,1,1,0,1},{0,0,0,0,1}};
        System.out.println(solution(maps));
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;

    public static int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        dfs(0, 0, maps, 0);
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
//        return bfs(0,0,maps);
    }

    public static void dfs(int x, int y, int[][] maps, int cnt) {

        cnt++;
        if (x == maps.length - 1 && y == maps[0].length - 1) {
            min = Math.min(cnt, min);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
                continue;
            if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, maps, cnt);
                visited[nx][ny] = false;
            }
        }
    }

    public static int bfs(int x, int y, int[][] maps) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, 1));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (node.x == maps.length - 1 && node.y == maps[0].length - 1)
                return node.cnt;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                if (nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length)
                    continue;
                if (maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, node.cnt + 1));
                }
            }
        }
        return -1;
    }

    static class Node {
        int x;
        int y;
        int cnt;

        public Node(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
