package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n2CutTheArrangement {
    public static void main(String[] args) { // 3페이지 & n^2 배열 자르기
        System.out.println(Arrays.toString(solution(4, 7, 14)));
    }
    public static int[] solution(int n, long left, long right) {
        List<Long> answer = new ArrayList<>();

        for (long i = left; i <= right; i++)
            answer.add(Math.max(i % n, i / n) + 1);

        return answer.stream().mapToInt(Long::intValue).toArray();
    }
}
