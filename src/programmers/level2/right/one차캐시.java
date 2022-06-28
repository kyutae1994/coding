package programmers.level2.right;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class one차캐시 {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};
        System.out.println(Arrays.toString(solution(places)));
    }

    static int[] dx = {1, -1 , 0, 0};
    static int[] dy = {0, 0 , 1, -1};
    public static int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = bfs(places[i]);
        }

        return answer;
    }
    public static int bfs(String[] places) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                char ch = places[i].charAt(j);
                if (ch == 'P') {
                    if (!chk(i, j, places))
                        return 0;
                }
            }
        }

        return 1;
    }

    public static boolean chk(int x, int y, String[] places) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        boolean[][] checked = new boolean[5][5];
        checked[x][y] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            for (int k = 0; k < 4; k++) {
                int nx = dx[k] + node.x;
                int ny = dy[k] + node.y;
                int distance = Math.abs(nx - x) + Math.abs(ny - y);

                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5) {
                    continue;
                }
                if (checked[nx][ny] || distance > 2)
                    continue;

                checked[nx][ny] = true;
                if (places[nx].charAt(ny) == 'X') {
                    continue;
                } else if (places[nx].charAt(ny) == 'P') {
                    return false;
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
