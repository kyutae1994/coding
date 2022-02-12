package programmers.level2;

import java.util.*;

public class Compression {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("KAKAO")));
    }
    public static int[] solution(String msg) {
        int[] answer = {};
        Map<Integer, String> map = new HashMap<>();
        int i = 0;
        for(i = 1; i <= 26; i++) {
            map.put(i, String.valueOf((char)(64 + i)));
        }

        boolean flag = false;
        for(int j = 0; j < msg.length() - 1; j++) {
            String word = msg.charAt(j) + "";

            while (map.containsValue(word)) {
                j++;
                if (j == msg.length()) {
                    flag = true;
                    break;
                }
                word += msg.charAt(j);
            }
            if (flag) {

            }
        }
        System.out.println(map);
        return answer;
    }
}
