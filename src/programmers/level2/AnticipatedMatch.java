package programmers.level2;

public class AnticipatedMatch {
    public static void main(String[] args) {
        System.out.println(solution(8, 4, 1));
    }
    public static int solution(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            answer++;
        }

        return answer;
    }
}
