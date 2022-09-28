package programmers.level4;

import java.util.Arrays;

public class 징검다리 {
    public static void main(String[] args) {
        System.out.println(solution(25, new int[]{2, 14, 11, 21, 17}, 2));
    }
    public static int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);

        int start = 0;
        int end = distance;
        int mid;

        while (start <= end) {
            mid = (start + end) / 2;
            int count = 0;
            int prev = 0;
            for (int i = 0; i < rocks.length; i++) {
                if (rocks[i] - prev < mid) {
                    count++;
                    if (count > n) {
                        break;
                    }
                } else {
                    prev = rocks[i];
                }
            }
            if (count <= n) {
                answer = mid > answer ? mid : answer;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return answer;
    }
}
