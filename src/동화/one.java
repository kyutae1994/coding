package 동화;

import java.util.Arrays;

public class one {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("31402", "*")));
    }
    public static long[] solution(String s, String op) {
        long[] answer = new long[s.length() - 1];
        for (int i = 1; i < s.length(); i++) {
            long result = 0L;
            long first = Long.parseLong(s.substring(0, i));
            long second = Long.parseLong(s.substring(i, s.length()));

            if (op.equals("+")) {
                result = first + second;
            } else if (op.equals("-")) {
                result = first - second;
            } else {
                result = first * second;
            }

            answer[i - 1] = result;
        }
        return answer;
    }
}
