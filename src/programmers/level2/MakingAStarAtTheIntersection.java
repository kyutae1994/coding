package programmers.level2;

import java.util.*;

public class MakingAStarAtTheIntersection {
    public static void main(String[] args) {
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        System.out.println(Arrays.toString(solution(line)));
    }

    static long minx = Long.MAX_VALUE, miny = Long.MAX_VALUE;
    static long maxx = Long.MIN_VALUE, maxy = Long.MIN_VALUE;

    public static String[] solution(int[][] line) {
        String[] answer = {};
        List<Point> list = new ArrayList<>();

        for (int i = 0; i < line.length - 1; i++) {
            long a = line[i][0];
            long b = line[i][1];
            long e = line[i][2];
            for (int j = i + 1; j < line.length; j++) {
                long c = line[j][0];
                long d = line[j][1];
                long f = line[j][2];

                long adbc = a * d - b * c;
                if (adbc == 0) continue;

                long bfed = b * f - e * d;
                if (bfed % adbc != 0) continue;

                long ecaf = e * c - a * f;
                if (ecaf % adbc != 0) continue;

                long x = bfed / adbc;
                long y = ecaf / adbc;
                list.add(new Point(x, y));

                minx = Math.min(minx, x);
                miny = Math.min(miny, y);
                maxx = Math.max(maxx, x);
                maxy = Math.max(maxy, y);
            }
        }

        int width = (int) (maxx - minx) + 1;
        int height = (int) (maxy - miny) + 1;
        answer = new String[height];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < width; i++) {
            sb.append('.');
        }
        Arrays.fill(answer, sb.toString());

        for (int i = 0; i < list.size(); i++) {
            int x = (int) (list.get(i).x - minx);
            int y = (int) (list.get(i).y - miny);

            System.out.println(x + " " + y);

            answer[height - y - 1] = answer[height - y - 1].substring(0, x) + "*" + answer[height - y - 1].substring(x + 1, width);
        }

        return answer;
    }

    static class Point {
        long x;
        long y;

        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
