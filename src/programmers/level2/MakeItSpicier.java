package programmers.level2;

import java.util.*;

public class MakeItSpicier {
    public static void main(String[] args) {
        int[] scoville = {1, 2, 3, 9, 10, 12};
        System.out.println(solution(scoville, 7));
    }
    public static int solution(int[] scoville, int K) {

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            q.add(scoville[i]);
        }
        int answer = 0;
        while (q.peek() < K) {
            if (q.size() == 1) return -1;
            int first = q.poll();
            int second = q.poll();
            int spicy = first + second * 2;
            q.add(spicy);
            answer++;
        }
        return answer;
    }
}
