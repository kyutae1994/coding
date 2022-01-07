package programmers.level2;

import java.util.Arrays;

public class RotatingTheBorderOfAMatrix {
    public static void main(String[] args) {
        int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
        System.out.println(Arrays.toString(solution(3, 3, queries)));
        int[][] queriess = {{1, 1, 100, 97}};
        System.out.println(Arrays.toString(solution(100, 97, queriess)));
    }

    public static int[] solution(int rows, int columns, int[][] queries) {

        int[][] arr = new int[rows][columns];
        int[] answer = new int[queries.length];

        int num = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = num++;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            int temp = 0;
            int stand = arr[x1][y1];
            int min = Integer.MAX_VALUE;
            for (int j = y1; j < y2; j++) {
                if (min > stand)
                    min = stand;
                temp = arr[x1][j + 1];
                arr[x1][j + 1] = stand;
                stand = temp;
            }
            for (int j = x1; j < x2; j++) {
                if (min > stand)
                    min = stand;
                temp = arr[j + 1][y2];
                arr[j + 1][y2] = stand;
                stand = temp;
            }
            for (int j = y2; j > y1; j--) {
                if (min > stand)
                    min = stand;
                temp = arr[x2][j - 1];
                arr[x2][j - 1] = stand;
                stand = temp;
            }
            for (int j = x2; j > x1; j--) {
                if (min > stand)
                    min = stand;
                temp = arr[j - 1][y1];
                arr[j - 1][y1] = stand;
                stand = temp;
            }

            answer[i] = min;
        }

        return answer;
    }
}
