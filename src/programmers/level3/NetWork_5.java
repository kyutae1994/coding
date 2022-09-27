package programmers.level3;

public class NetWork_5 {
    public static void main(String[] args) {
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        System.out.println(solution(3, computers));
    }

    static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited = dfs(i, computers);
                answer++;
            }
        }

        return answer;
    }

    public static boolean[] dfs(int i, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < visited.length; j++) {
            if (i != j && !visited[j] && computers[i][j] == 1) {
                dfs(j, computers);
            }
        }

        return visited;
    }
}
