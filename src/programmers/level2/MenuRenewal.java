package programmers.level2;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};
        System.out.println(Arrays.toString(solution(orders, course)));
    }

    static Map<String, Integer> map = new HashMap<>();
    public static String[] solution(String[] orders, int[] course) {

        for (String key : orders) {
            char[] c = key.toCharArray();
            Arrays.sort(c);
            for (int i = 0; i < course.length; i++) {
                dfs(0, 0, c, course[i], "");
            }
        }

        int[] maxCnt = new int[course[course.length - 1] + 1];
        for (String key : map.keySet()) {
            if (map.get(key) > 1) {
                maxCnt[key.length()] = Math.max(maxCnt[key.length()], map.get(key));
            }
        }

        List<String> list = new ArrayList<>();
        for (String key : map.keySet()) {
            for (int i = 0; i < maxCnt.length; i++) {
                if (maxCnt[i] == 0) continue;
                if (map.get(key) == maxCnt[i] && i == key.length()) {
                    list.add(key);
                }
            }
        }

        Collections.sort(list);
        String[] answer = new String[list.size()];
        int i = 0;
        for (String key : list) {
            answer[i++] = key;
        }

        return answer;
    }

    public static void dfs(int idx, int start, char[] order, int course, String result) {
        if (idx == course) {
            map.put(result, map.getOrDefault(result, 0) + 1);
            return;
        }

        for (int i = start; i < order.length; i++) {
            dfs(idx + 1, i + 1, order, course, result + order[i]);
        }
    }
}
