package programmers.level1;

import java.util.*;

public class PressingTheKeypad {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
        System.out.println(solution(numbers, "right"));
    }

    public static String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                left = numbers[i];
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                right = numbers[i];
            } else {
                int leftLen = getLen(left, numbers[i]);
                int rightLen = getLen(right, numbers[i]);

                if (leftLen > rightLen) {
                    answer += "R";
                    right = numbers[i];
                } else if (leftLen < rightLen) {
                    answer += "L";
                    left = numbers[i];
                } else {
                    if (hand.equals("right")) {
                        answer += "R";
                        right = numbers[i];
                    } else {
                        answer += "L";
                        left = numbers[i];
                    }
                }
            }
        }

        return answer;
    }

    public static int getLen(int index, int number) {
        index = index == 0 ? 11 : index;
        number = number == 0 ? 11 : number;

        int x = (index - 1) / 3;
        int y = (index - 1) % 3;
        int numberX = (number - 1) / 3;
        int numberY = (number - 1) % 3;

        return Math.abs(x - numberX) + Math.abs(y - numberY);
    }
}
