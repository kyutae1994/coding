package BackJoon.BackTracking;

import java.util.Scanner;

public class TheSumofThePartialSequences { // 부분수열의 합
    static int N, S;
    static int[] arr;
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        dfs(0, 0);

        System.out.println(S == 0 ? ans - 1 : ans);
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) {
            if (sum == S) {
                ans++;
            }
            return;
        }

        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}
