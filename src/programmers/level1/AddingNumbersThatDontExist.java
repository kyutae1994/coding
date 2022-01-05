package programmers.level1;

import java.util.*;

public class AddingNumbersThatDontExist {
    public static void main(String[] args) {
        int[] numbers = {5,8,4,0,6,7,9};
        System.out.println(solution(numbers));
    }
    public static int solution(int[] numbers) {
        int answer = 45;
        for (int i = 0; i < numbers.length; i++) {
            answer -= numbers[i];
        }
        return answer;
    }
}
