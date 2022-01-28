package programmers.level2;

import java.util.Arrays;

public class CountingTheNumberOfQuadsAfterCompressed {
    public static void main(String[] args) {
        int[][] arr = {{1,1,0,0},{1,0,0,0},{1,0,0,1},{1,1,1,1}};
        System.out.println(Arrays.toString(solution(arr)));
    }
    static int[] answer;
    public static int[] solution(int[][] arr) {
        answer = new int[2];
        quad(arr.length, 0, 0, arr);
        return answer;
    }

    public static void quad(int n, int x, int y, int[][] arr) {
        boolean isZero = true;
        boolean isOne = true;

        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(arr[i][j] == 1) isZero = false;
                if(arr[i][j] == 0) isOne = false;
            }
        }

        if(isOne) {
            answer[1]++;
            return;
        }
        if(isZero) {
            answer[0]++;
            return;
        }

        quad(n / 2, x, y, arr);
        quad(n / 2, x + n / 2, y, arr);
        quad(n / 2, x, y + n / 2, arr);
        quad(n / 2, x + n / 2, y + n / 2, arr);
    }
}
