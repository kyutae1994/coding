package programmers.level2;

public class VisitedLength {  // 3페이지 & 방문길이
    static int[] u = {0, 1};
    static int[] d = {0, -1};
    static int[] l = {-1, 0};
    static int[] r = {1, 0};
    static boolean[][][][] visited = new boolean[11][11][11][11];

    public static void main(String[] args) {
        System.out.println(solution("ULURRDLLU"));
    }
    public static int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;

        for(int i = 0; i < dirs.length(); i++) {
            char ch = dirs.charAt(i);
            int nx = 0, ny = 0;
            if(ch == 'U') {
                nx = x + u[0];
                ny = y + u[1];
            } else if(ch == 'D') {
                nx = x + d[0];
                ny = y + d[1];
            } else if(ch == 'L') {
                nx = x + l[0];
                ny = y + l[1];
            } else {
                nx = x + r[0];
                ny = y + r[1];
            }

            if(nx > 10 || ny > 10 || nx < 0 || ny < 0) continue;

            int tempX = x;
            int tempY = y;
            x = nx;
            y = ny;

            if(visited[tempX][tempY][x][y] && visited[x][y][tempX][tempY]) continue;
            visited[tempX][tempY][x][y] = true;
            visited[x][y][tempX][tempY] = true;

            answer++;
        }
        return answer;
    }
}
