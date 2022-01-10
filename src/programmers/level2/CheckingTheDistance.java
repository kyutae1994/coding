package programmers.level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CheckingTheDistance {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                             {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                             {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                             {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                             {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0 ,1, -1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = find(places[i]);
        }
        return answer;
    }

    public static int find(String[] places) {
        for (int i = 0; i < places.length; i++) {
            for (int j = 0; j < places[0].length(); j++) {
                if (places[i].charAt(j) == 'P') {
                    if (!bfs(i, j, places)) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public static boolean bfs(int x, int y, String[] places) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        boolean[][] checked = new boolean[places.length][places[0].length()];
        checked[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + node.x;
                int ny = dy[i] + node.y;
                int distance = Math.abs(nx - x) + Math.abs(ny - y);
                if (nx < 0 || nx >= places.length || ny < 0 || ny >= places[0].length())
                    continue;
                if (checked[nx][ny] || distance > 2)
                    continue;
                checked[nx][ny] = true;
                if (places[nx].charAt(ny) == 'P') {
                    return false;
                } else if (places[nx].charAt(ny) == 'X') {
                    continue;
                } else {
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return true;
    }

    static class Node {
        int x;
        int y;
        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
