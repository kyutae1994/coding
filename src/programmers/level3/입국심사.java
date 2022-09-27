package programmers.level3;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{7, 10}));
    }
    public static long solution(int n, int[] times) {
        long start = 0;
        long end = (long)n * times[times.length - 1];
        long mid = 0, answer = 0;

        while (start <= end) {
            mid = (start + end) / 2;

            long sum = 0;
            for (int i = 0; i < times.length; i++) {
                sum += (mid / times[i]);
                if (sum >= n)
                    break;
            }

            if (sum < n) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}
