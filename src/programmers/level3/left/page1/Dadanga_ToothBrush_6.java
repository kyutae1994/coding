package programmers.level3.left.page1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Dadanga_ToothBrush_6 {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller = {"young", "john", "tod", "emily", "mary"};
        int[] amount = {12, 4, 2, 5, 10};
        System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
    }

    static Map<String, Integer> map = new HashMap<>(); // <사람, 총 금액>
    static Map<String, String> connect = new HashMap<>(); // <사람, 부모>

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];

        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], 0);
            connect.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            dfs(seller[i], amount[i] * 100);
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = map.get(enroll[i]);
        }

        return answer;
    }

    public static void dfs(String name, int money) {
        if (name.equals("-") || money == 0)
            return;

        int mainMoney = (int)Math.ceil(money * 0.9);
        int restMoney = money - mainMoney;
        String next = connect.get(name);
        map.replace(name, map.get(name) + mainMoney);
        dfs(next, restMoney);
    }
}
