package programmers.level1;

import java.util.Arrays;
public class TheHighestAndLowestRankingInTheLottery {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] win_nums = {31, 10, 45, 1, 6, 19};
        System.out.println(Arrays.toString(solution(lottos, win_nums)));
    }
    public static int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int cnt = 0;
        int zero = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0)
                zero++;
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    cnt++;
                    break;
                }
            }
        }

        int max = cnt + zero;
        int min = cnt;
        answer[0] = max;
        answer[1] = min;
        for (int i = 0; i < 2; i++) {
            switch (answer[i]) {
                case 6 : answer[i] = 1; break;
                case 5 : answer[i] = 2; break;
                case 4 : answer[i] = 3; break;
                case 3 : answer[i] = 4; break;
                case 2 : answer[i] = 5; break;
                default: answer[i] = 6; break;
            }
        }

        return answer;
    }
}
