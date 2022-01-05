package programmers.level2;

public class NormalSquare {
    public static void main(String[] args) {
        System.out.println(solution(8, 12));
    }
    public static long solution(int w, int h) {
        long width = Long.valueOf(w);
        long height = Long.valueOf(h);
        long answer = width * height - ((width / g(width, height) + height / g(width, height) - 1) * g(width, height));
        return answer;
    }

    public static long g(long w, long h) {
        long small = h;
        long big = w;
        if (w < h) {
            big = h;
            small = w;
        }

        long temp = 0;
        while (small > 0) {
            temp = big % small;

            big = small;
            small = temp;
        }
        return big;
    }
}
