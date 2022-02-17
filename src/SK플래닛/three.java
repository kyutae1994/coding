package SK플래닛;

import java.util.*;

public class three {
    public static void main(String[] args) {
        String[] color = {"RG", "WR", "BW", "GG"};
        int[] prices = {2000, 6000};
        System.out.println(solution(color, prices));
    }
    public static int solution(String[] color, int[] prices) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < color.length; i++) {
            String ch1 = color[i].charAt(0) + "";
            String ch2 = color[i].charAt(1) + "";
            list1.add(ch1);
            list2.add(ch2);
            if (list1.contains(ch2)) {
                answer += prices[0];
                list1.remove(String.valueOf(ch2));
                list2.remove(String.valueOf(ch2));
                map.put(String.valueOf(ch2), map.getOrDefault(String.valueOf(ch2), 0) + 1);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            answer += prices[1];
        }

        int cnt = 0;
        for (int key : map.values()) {
            cnt += key;
        }
        cnt += list1.size() + list2.size();

        return answer > prices[0] * cnt ? prices[0] * cnt : answer;
    }
}
