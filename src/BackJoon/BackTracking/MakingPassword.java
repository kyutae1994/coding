package BackJoon.BackTracking;

import java.util.Arrays;
import java.util.Scanner;

public class MakingPassword {  // 암호만들기
    static int L, C;
    static char[] arr;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        arr = new char[C];
        visited = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = sc.next().charAt(0);
        }

        Arrays.sort(arr);
        dfs(0, 0);
    }

    public static void dfs(int start, int depth) {

        if (depth == L) {
            int v = 0;
            int cc = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < C; i++) {
                if (visited[i]) {
                    sb.append(arr[i]);

                    if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' ||arr[i] == 'u')
                        v++;
                    else
                        cc++;
                }
            }

            if (v >= 1 && cc >= 2)
                System.out.println(sb);
        }

        for (int i = start; i < C; i++) {
            visited[i] = true;
            dfs(i + 1, depth + 1);
            visited[i] = false;
        }
    }

}
