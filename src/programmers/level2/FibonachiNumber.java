package programmers.level2;
import java.util.*;
public class FibonachiNumber { // 4페이지 & 피보나치 수
    public static void main(String[] args) {
        System.out.println(solution(5));
    }
    public static int solution(int n) {
        List<Long> list = new ArrayList<>();
        list.add(0L);
        list.add(1L);
        for(int i = 2; i <= n; i++) {
            list.add((list.get(i - 2) + list.get(i - 1)) % 1234567);
        }
        return list.get(n).intValue();
    }
}
