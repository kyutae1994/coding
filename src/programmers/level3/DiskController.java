package programmers.level3;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
    }
    public static int solution(int[][] jobs) {
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int answer = 0;
        int count = 0;
        int jobsIdx = 0;
        int end = 0;
        while (count < jobs.length) {
            while (jobsIdx < jobs.length && jobs[jobsIdx][0] <= end) {
                q.add(jobs[jobsIdx++]);
            }
            if (q.isEmpty()) {
                end = jobs[jobsIdx][0];
            } else {
                int[] temp = q.poll();
                answer += temp[1] + end - temp[0];
                end += temp[1];
                count++;
            }
        }
        return (int) Math.floor(answer / jobs.length);
    }
}
