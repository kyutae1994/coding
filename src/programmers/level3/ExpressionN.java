package programmers.level3;

public class ExpressionN { // 1페이지 & N으로 표현
    public static void main(String[] args) {
        System.out.println(solution(5, 12));
    }
    static int min = Integer.MAX_VALUE;
    public static int solution(int N, int number) {
        dfs(0, N, number, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void dfs(int depth, int N, int number, int current) {
        if(depth > 8) {
            return;
        }

        if(current == number) {
            min = Math.min(depth, min);
            return;
        }

        int temp = 0;

        for (int i = 0; i < 8; i++) {
            if (depth + i < 8) {
                temp = temp * 10 + N;
                dfs(depth + i + 1, N, number, current + temp);
                dfs(depth + i + 1, N, number, current - temp);
                dfs(depth + i + 1, N, number, current / temp);
                dfs(depth + i + 1, N, number, current * temp);
            }
        }
    }
}
