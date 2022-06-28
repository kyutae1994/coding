package 오토에버;

import java.util.Arrays;

public class two {
    public static void main(String[] args) {
        int[][] swipes = {{3,1,2,2,4},{3,1,2,2,4},{4,2,1,2,3},{1,1,1,2,3}};
        System.out.println(Arrays.toString(solution(2,4,swipes)));
    }
    public static int[] solution(int rows, int columns, int[][] swipes) {
        int[] answer = new int[swipes.length];
        int[][] arr = new int[rows][columns];
        int cnt = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                arr[i][j] = cnt++;
            }
        }

        for (int i = 0; i < swipes.length; i++) {
            int way = swipes[i][0];
            int firstRow = swipes[i][1] - 1;
            int firstCol = swipes[i][2] - 1;
            int secondRow = swipes[i][3] - 1;
            int secondCol = swipes[i][4] - 1;

            if (way == 1) {
                for (int j = firstCol; j <= secondCol; j++) {
                    answer[i] += arr[secondRow][j];
                }
                for (int j = firstCol; j <= secondCol; j++) {
                    for (int k = secondRow; k > firstRow; k--) {
                        int temp = arr[k][j];
                        arr[k][j] = arr[k - 1][j];
                        arr[k - 1][j] = temp;
                    }
                }
            } else if (way == 2) {
                for (int j = firstCol; j <= secondCol; j++) {
                    answer[i] += arr[firstRow][j];
                }
                for (int j = firstCol; j <= secondCol; j++) {
                    for (int k = firstRow; k < secondRow; k++) {
                        int temp = arr[k][j];
                        arr[k][j] = arr[k + 1][j];
                        arr[k + 1][j] = temp;
                    }
                }
            } else if (way == 3) {
                for (int j = firstRow; j <= secondRow; j++) {
                    answer[i] += arr[j][secondCol];
                }
                for (int j = firstRow; j <= secondRow; j++) {
                    for (int k = secondCol; k > firstCol; k--) {
                        int temp = arr[j][k];
                        arr[j][k] = arr[j][k - 1];
                        arr[j][k - 1] = temp;
                    }
                }
            } else {
                for (int j = firstRow; j <= secondRow; j++) {
                    answer[i] += arr[j][firstCol];
                }
                for (int j = secondRow; j >= firstRow; j--) {
                    for (int k = firstCol; k < secondCol; k++) {
                        int temp = arr[j][k];
                        arr[j][k] = arr[j][k + 1];
                        arr[j][k + 1] = temp;
                    }
                }
            }
        }
        return answer;
    }
}
