package BackJoon.BackTracking;

import java.util.Scanner;

public class Sudoku { // 스도쿠 2580
    static int[][] arr = new int[9][9];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        dfs(0, 0);
    }

    public static void dfs(int row, int col) {
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        if (row == 9) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(arr[i][j]).append(' ');
                }
                sb.append('\n');
            }
            System.out.println(sb);
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                if (check(row, col, i)) {
                    arr[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        dfs(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {

        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == value) {
                return false;
            }
        }

        for (int i = 0; i < 9; i++) {
            if (arr[i][col] == value) {
                return false;
            }
        }

        int real_R = row / 3 * 3;
        int real_C = col / 3 * 3;

        for (int i = real_R; i < real_R + 3; i++) {
            for (int j = real_C; j < real_C + 3; j++) {
                if (arr[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }

}
