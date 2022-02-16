package BackJoon.BackTracking;

import java.util.Scanner;

public class StartAndLink { // 스타트와 링크
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n][n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int idx, int depth) {
        if (depth == n / 2) {
            check();
            return;
        }

        for (int i = idx; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void check() {
        int first = 0;
        int second = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visited[i] && visited[j]) {
                    first += arr[i][j];
                    first += arr[j][i];
                } else if (!visited[i] && !visited[j]) {
                    second += arr[i][j];
                    second += arr[j][i];
                }
            }
        }

        int val = Math.abs(first - second);
        if (val == 0) {
            System.out.println(val);
            System.exit(0);
        }
        min = Math.min(min, val);
    }
}
