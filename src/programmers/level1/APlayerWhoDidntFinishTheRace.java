package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class APlayerWhoDidntFinishTheRace {
    public static void main(String[] args) {
        String[] participant = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        System.out.println(solution(participant, completion));
    }
    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new HashMap<>();
        for (String part : participant) {
            map.put(part, map.getOrDefault(part, 0) + 1);
        }

        for (String com : completion) {
            if (map.containsKey(com)) {
                int val = map.get(com);
                map.put(com, val - 1);
            }
        }

        String answer = "";
        for (String key : participant) {
            if (map.get(key) == 1) {
                answer = key;
            }
        }

        return answer;
    }
}
