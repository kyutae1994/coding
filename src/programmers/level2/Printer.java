package programmers.level2;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Printer {
    public static void main(String[] args) {
        int[] priorities = {1, 1, 9, 7, 6, 5};
        System.out.println(solution(priorities, 0));
    }
    public static int solution(int[] priorities, int location) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int p : priorities) {
            pq.add(p);
        }

        int min = 1;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] == pq.peek()) {
                    if (i == location)
                        return min;
                    pq.poll();
                    min++;
                }
            }
        }

        return min;
    }
}
