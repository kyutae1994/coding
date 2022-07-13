package programmers.level2.test;

import java.util.Arrays;

public class three {
    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
    }
    public static long solution(String expression) {
        long answer = 0;
        String[] num = expression.split("[0-9]+", 0);
        String[] cal = expression.split("[\\*|\\-|\\+]");

        System.out.println(Arrays.toString(num));
        System.out.println(Arrays.toString(cal));
        return answer;
    }
}
