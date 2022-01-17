package programmers.level2;

public class JotStick {
    public static void main(String[] args) {
        System.out.println(solution("JEROEN"));
        System.out.println(solution("JAN"));
    }
    public static int solution(String name) {

        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            int temp = name.charAt(i) - 'A';
            if (temp == 0) continue;
            answer += Math.min(temp, 26 - temp);
        }

        int minCount = name.length() - 1;
        for (int i = 0; i < name.length(); i++) {
            int check = i + 1;
            while (check < name.length() && name.charAt(check) == 'A')
                check++;
            int moveCount = i + name.length() - check + Math.min(i, name.length() - check);
            minCount = Math.min(minCount, moveCount);
        }

        return 1;
    }
}
