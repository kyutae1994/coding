package SK플래닛;

import java.util.ArrayList;
import java.util.Arrays;

public class two {
    public static void main(String[] args) {
        int[] deposit = {500, 1000, 2000, -1000, -1500, 500};
        System.out.println(Arrays.toString(solution(deposit)));
    }
    public static int[] solution(int[] deposit) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < deposit.length; i++) {
            if (deposit[i] > 0) {   // 입금
                list.add(deposit[i]);
            } else {    // 출금
                int cost = deposit[i];
                cost *= -1;
                if (list.get(list.size() - 1) > cost) {  // 출금이 마지막 입금보다 작을 때
                    int last = list.remove(list.size() - 1);
                    last += deposit[i];
                    list.add(last);
                } else {    // 출금이 마지막 입금보다 클 때
                    while (cost >= 0) {
                        if (list.get(list.size() - 1) < cost) {
                            cost -= list.remove(list.size() - 1);
                        } else {
                            int last = list.remove(list.size() - 1);
                            last -= cost;
                            if (last > 0)
                                list.add(last);
                            cost = -1;
                        }
                    }
                }
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
