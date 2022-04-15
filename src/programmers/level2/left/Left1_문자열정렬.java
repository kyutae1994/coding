package programmers.level2.left;

public class Left1_문자열정렬 {
    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        for(int i = 1; i <= len / 2; i++) {
            String before = s.substring(0, i);
            String temp = "";
            int cnt = 1;
            for(int j = 1; j < len / i; j++) {
                String current = s.substring(j * i, j * i + i);
                if(before.equals(current)) {
                    cnt++;
                } else {
                    if(cnt == 1) {
                        temp += before;
                    } else {
                        temp += cnt + before;
                        cnt = 1;
                    }
                }

                before = current;
            }

            if(cnt == 1) {
                temp += before;
            } else {
                temp += cnt + before;
            }

            //for(int j = len - (len % i); j < len; j += i) {
            temp += s.substring(len - len % i, len);
            //}

            if(answer > temp.length())
                answer = temp.length();
        }

        return answer;
    }
}