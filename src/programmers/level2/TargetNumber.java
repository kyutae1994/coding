package programmers.level2;

public class TargetNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        System.out.println(solution(numbers, 3));
    }
    public static int solution(int[] numbers, int target) {

        return dfs(numbers, target, numbers[0], 1) + dfs(numbers, target, -numbers[0], 1);
    }

    public static int dfs(int[] numbers, int target, int sum, int idx) {

        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int answer = 0;
        answer += dfs(numbers, target, sum + numbers[idx], idx + 1);
        answer += dfs(numbers, target, sum - numbers[idx], idx + 1);

        return answer;
    }
}
