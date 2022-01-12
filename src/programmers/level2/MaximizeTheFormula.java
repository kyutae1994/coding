package programmers.level2;

import java.util.*;

public class MaximizeTheFormula {
    public static void main(String[] args) {
        System.out.println(solution("50*6-3*2"));
    }

    static List<Long> numbers = new ArrayList<>();
    static List<Character> operators = new ArrayList<>();

    public static long solution(String expression) {

        long answer = 0;
        String num = "";

        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '-' || expression.charAt(i) == '+' || expression.charAt(i) == '*') {
                operators.add(expression.charAt(i));
                numbers.add(Long.parseLong(num));
                num = "";
            } else {
                num += expression.charAt(i);
            }
        }
        numbers.add(Long.parseLong(num));

        long[] result = new long[6];
        result[0] = operation('+', '-', '*');
        result[1] = operation('+', '*', '-');
        result[2] = operation('-', '+', '*');
        result[3] = operation('-', '*', '+');
        result[4] = operation('*', '-', '+');
        result[5] = operation('*', '+', '-');

        for (int i = 0; i < 6; i++) {
            if (answer < Math.abs(result[i]))
                answer = Math.abs(result[i]);
        }

        return answer;
    }

    public static void calc(List<Long> nums, List<Character> opers, char op) {
        for (int i = 0; i < opers.size(); i++) {
            if (opers.get(i) == op) {
                long num1 = nums.get(i);
                long num2 = nums.get(i + 1);
                long result = cal(num1, num2, op);
                nums.remove(i);
                nums.remove(i);
                nums.add(i, result);
                opers.remove(i);
                i--;
            }
        }
    }

    public static long operation(char op1, char op2, char op3) {
        List<Long> nums = new ArrayList<>(numbers);
        List<Character> opers = new ArrayList<>(operators);
        calc(nums, opers, op1);
        calc(nums, opers, op2);
        calc(nums, opers, op3);
        return nums.get(0);
    }

    public static long cal(long a, long b, char op){
        if(op == '+')
            return a + b;
        else if(op == '-')
            return a - b;
        else
            return a * b;
    }
}
