package SK플래닛;

import java.util.Arrays;

public class one {
    public static void main(String[] args) {
        int[] t = {3,5,2,9,8};
        System.out.println(solution(t, 3));
    }
    public static int solution(int[] t, int m) {
        int answer = 0;
        Arrays.sort(t);
        for (int i = 0; i < m; i++) {
            answer += t[i] + 1;
        }

        return answer;
    }
}
