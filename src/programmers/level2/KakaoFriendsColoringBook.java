package programmers.level2;

import java.util.Arrays;

public class KakaoFriendsColoringBook {
    public static void main(String[] args) {
        int[][] picture = { {1, 1, 1, 0}, 
                            {1, 2, 2, 0}, 
                            {1, 0, 0, 1}, 
                            {0, 0, 0, 1}, 
                            {0, 0, 0, 3}, 
                            {0, 0, 0, 3}};
        System.out.println(Arrays.toString(solution(6, 4, picture)));
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean[][] check;
    static int temp_cnt = 0;
    public static void dfs(int x, int y, int[][] picture) {
        if (check[x][y]) return;
        check[x][y] = true;
        temp_cnt++;

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || nx >= picture.length || ny < 0 || ny >= picture[0].length) continue;
            if (picture[x][y] == picture[nx][ny] && !check[nx][ny]) {
                dfs(nx, ny, picture);
            }
        }
    }
    public static int[] solution(int m, int n, int[][] picture) {
        check = new boolean[m][n];
        int areaCnt = 0;
        int areaMax = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !check[i][j]) {
                    areaCnt++;
                    dfs(i, j, picture);
                }
                if (temp_cnt > areaMax) {
                    areaMax = temp_cnt;
                }
                temp_cnt = 0;
            }
        }
        int[] answer = new int[2];
        answer[0] = areaCnt;
        answer[1] = areaMax;
        return answer;
    }
}
