package programmers.level2.left;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 하노이의탑 {
    public static void main(String[] args) {
        System.out.println(solution(3));
    }
    static List<int[]> list = new ArrayList<>();
    public static int[][] solution(int n) {

        hanoi(n, 1, 3, 2);

        int[][] answer = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            int[] cmd = list.get(i);
            answer[i][0] = cmd[0];
            answer[i][1] = cmd[1];
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(Arrays.toString(list.get(i)));
        }
        return answer;
    }

    public static void hanoi(int n, int from, int to, int via) {
        int[] move = {from, to};

        if (n == 1) {
            list.add(move);
        } else {
            hanoi(n - 1, from, via, to);
            list.add(move);
            hanoi(n - 1, via, to, from);
        }
    }
}
