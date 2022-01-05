package programmers.level2;

public class TheNumberOf124Countries {
    public static void main(String[] args) {
        System.out.println(solution(10));
    }
    public static String solution(int n) {
        String answer = "";
        String[] arr = {"4", "1", "2"};


        while (n > 0) {
            answer = arr[n % 3] + answer;
            n = (n - 1) / 3;
        }

        return answer;
    }
}
