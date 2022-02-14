package programmers.level2;

import java.util.Arrays;

public class MakeJadenCase {  //4페이지 & JadenCase 문자열 만들기
    public static void main(String[] args) {
        System.out.println(solution("a a a a a a a a"));
    }
    public static String solution(String s) {
        String first = s.charAt(0) + "";
        StringBuilder answer = new StringBuilder();
        answer.append(first.toUpperCase());

        for (int i = 1; i < s.length(); i++) {
            String cur = s.charAt(i) + "";
            if (cur.equals(" "))
                answer.append(" ");
            else if (s.charAt(i - 1) == ' ')
                answer.append(cur.toUpperCase());
            else
                answer.append(cur.toLowerCase());
        }
        return answer.toString();
    }
}
