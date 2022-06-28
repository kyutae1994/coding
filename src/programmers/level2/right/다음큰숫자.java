package programmers.level2.right;

public class 다음큰숫자 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    public static int solution(int n) {

        String binN = Integer.toBinaryString(n);
        int cntN = 0;
        for (int i = 0; i < binN.length(); i++) {
            char ch = binN.charAt(i);
            if (ch == '1') {
                cntN++;
            }
        }

        int answer = n;
        String binAnswer = "";
        int cntAnswer = 0;
        while (true) {
            answer++;
            binAnswer = Integer.toBinaryString(answer);
            cntAnswer = 0;
            for (int i = 0; i < binAnswer.length(); i++) {
                char ch = binAnswer.charAt(i);
                if (ch == '1') {
                    cntAnswer++;
                }
            }

            if (cntN == cntAnswer)
                break;
        }

        return answer;
    }
}
