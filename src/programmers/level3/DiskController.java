package programmers.level3;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0,3},{1,9},{2,6}};
        System.out.println(solution(jobs));
        String a = 23.3333 + "";
        System.out.println(a.length());

        System.out.println(DateTimeFormatter.ofPattern("MMdd").format(LocalDateTime.now()));
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        String ccc= sdf.format(timestamp);
        System.out.println(System.currentTimeMillis());
        System.out.println(Long.parseLong(sdf.format(timestamp)));
        System.out.println(Timestamp.valueOf("2022-11-02"));
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
