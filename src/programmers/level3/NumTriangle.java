package programmers.level3;

public class NumTriangle { // 1페이지 & 정수 삼각형
    public static void main(String[] args) {
        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(triangle));
    }
    public static int solution(int[][] triangle) {
        int[][] dp = triangle.clone();

        for (int i = triangle.length - 2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i + 1][j + 1]) + triangle[i][j];
            }
        }
        return dp[0][0];
    }
}
