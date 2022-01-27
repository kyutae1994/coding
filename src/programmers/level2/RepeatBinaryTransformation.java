package programmers.level2;

import java.util.Arrays;

public class RepeatBinaryTransformation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("110010101001")));
    }
    public static int[] solution(String s) {
        int[] answer = new int[2];
        int deleteZero = 0, cnt = 0;
        while(!s.equals("1")) {
            int len = s.length();
            s = s.replace("0", "");
            deleteZero += len - s.length();
            s = Integer.toBinaryString(s.length());
            cnt++;
        }

        answer[0] = cnt;
        answer[1] = deleteZero;

        return answer;
    }
}
