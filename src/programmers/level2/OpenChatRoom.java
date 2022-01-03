package programmers.level2;

import java.util.*;

public class OpenChatRoom {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        System.out.println(Arrays.toString(solution(record)));
    }
    public static String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter") || str[0].equals("Change")) {
                map.put(str[1], str[2]);
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            String[] str = record[i].split(" ");
            if (str[0].equals("Enter")) {
                list.add(map.get(str[1]) + "님이 들어왔습니다.");
            } else if (str[0].equals("Leave")) {
                list.add(map.get(str[1]) + "님이 나갔습니다.");
            }
        }

        answer = new String[list.size()];
        int i = 0;
        for (String key : list) {
            answer[i++] = key;
        }

        return answer;
    }
}
