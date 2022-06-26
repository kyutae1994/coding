package programmers.level2.right;

import java.util.*;

public class 줄서는방법 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, 5)));
    }
    public static int[] solution(int n, long k) {

        int[] answer = new int[n];
        List<Integer> list = new ArrayList<>();

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
            list.add(i);
        }
        k--;

        int idx = 0;
        while(n > 0) {
            fact /= n;
            answer[idx++] = list.get((int) (k / fact));
            list.remove((int) (k / fact));
            k %= fact;
            n--;
        }

        return answer;
    }
}
