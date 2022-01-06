package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FunctionDevelopment {
    public static void main(String[] args) {
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {

        int[] deadLine = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            int last = 100 - progresses[i];
            int lastDay = 0;
            if (last % speeds[i] == 0) {
                lastDay = last / speeds[i];
            } else {
                lastDay = last / speeds[i] + 1;
            }
            deadLine[i] = lastDay;
        }

        int first = deadLine[0];
        int cnt = 1;
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < deadLine.length; i++) {
            if (first < deadLine[i]) {
                list.add(cnt);
                cnt = 1;
                first = deadLine[i];
            } else {
                cnt++;
            }
        }
        list.add(cnt);
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
