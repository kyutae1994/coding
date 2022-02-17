package SK플래닛;

import java.util.ArrayList;
import java.util.Arrays;

public class four {
    public static void main(String[] args) {
        String[] rsp3 = {"RRR", "SPS"};
        System.out.println(Arrays.toString(solution(rsp3)));
    }
    public static int[] solution(String[] rsp3) {
        int[] answer = {0, 0, 0};
        for (int i = 0; i < rsp3.length; i++) {
            char p1 = rsp3[i].charAt(0);
            char p2 = rsp3[i].charAt(1);
            char p3 = rsp3[i].charAt(2);

            char result = getWin(p1, p2, p3);
            if (result == 'N')
                continue;

            String temp = rsp3[i];

            int cnt = 3 - temp.replace(result + "", "").length();
            if (cnt == 1) {
                for (int j = 0; j < 3; j++) {
                    if (result == rsp3[i].charAt(j)) {
                        answer[j] += 2;
                    }
                }
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    if (result == rsp3[i].charAt(j)) {
                        list.add(j);
                    }
                }
                if (answer[list.get(0)] == answer[list.get(1)]) {
                    answer[list.get(0)]++;
                    answer[list.get(1)]++;
                } else {
                    if (answer[list.get(0)] > answer[list.get(1)])
                        answer[list.get(1)] += 2;
                    else
                        answer[list.get(0)] += 2;
                }
            }
        }
        return answer;
    }

    public static Character getWin(char p1, char p2, char p3) {
        if (p1 == 'R' && p2 == 'S' && p3 == 'P') {
            return 'N';
        } else if (p1 == 'R' && p2 == 'S' && p3 == 'R') {
            return 'R';
        } else if (p1 == 'R' && p2 == 'S' && p3 == 'S') {
            return 'R';
        } else if (p1 == 'R' && p2 == 'R' && p3 == 'R') {
            return 'N';
        } else if (p1 == 'R' && p2 == 'R' && p3 == 'S') {
            return 'R';
        } else if (p1 == 'R' && p2 == 'R' && p3 == 'P') {
            return 'P';
        } else if (p1 == 'R' && p2 == 'P' && p3 == 'R') {
            return 'P';
        } else if (p1 == 'R' && p2 == 'P' && p3 == 'S') {
            return 'N';
        } else if (p1 == 'R' && p2 == 'P' && p3 == 'P') {
            return 'P';
        } else if (p1 == 'S' && p2 == 'S' && p3 == 'P') {
            return 'S';
        } else if (p1 == 'S' && p2 == 'S' && p3 == 'R') {
            return 'R';
        } else if (p1 == 'S' && p2 == 'S' && p3 == 'S') {
            return 'N';
        } else if (p1 == 'S' && p2 == 'R' && p3 == 'R') {
            return 'R';
        } else if (p1 == 'S' && p2 == 'R' && p3 == 'S') {
            return 'R';
        } else if (p1 == 'S' && p2 == 'R' && p3 == 'P') {
            return 'N';
        } else if (p1 == 'S' && p2 == 'P' && p3 == 'R') {
            return 'N';
        } else if (p1 == 'S' && p2 == 'P' && p3 == 'S') {
            return 'S';
        } else if (p1 == 'S' && p2 == 'P' && p3 == 'P') {
            return 'S';
        } else if (p1 == 'P' && p2 == 'S' && p3 == 'P') {
            return 'S';
        } else if (p1 == 'P' && p2 == 'S' && p3 == 'R') {
            return 'N';
        } else if (p1 == 'P' && p2 == 'S' && p3 == 'S') {
            return 'S';
        } else if (p1 == 'P' && p2 == 'R' && p3 == 'R') {
            return 'P';
        } else if (p1 == 'P' && p2 == 'R' && p3 == 'S') {
            return 'N';
        } else if (p1 == 'P' && p2 == 'R' && p3 == 'P') {
            return 'P';
        } else if (p1 == 'P' && p2 == 'P' && p3 == 'R') {
            return 'P';
        } else if (p1 == 'P' && p2 == 'P' && p3 == 'S') {
            return 'S';
        } else if (p1 == 'P' && p2 == 'P' && p3 == 'P') {
            return 'N';
        }
        return p1;
    }
}
