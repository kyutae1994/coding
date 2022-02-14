package programmers.level2;
import java.util.*;
public class TheMinimumMultipleofN {
    public static void main(String[] args) {
        int[] arr= {2,6,8,14};
        System.out.println(solution(arr));
    }
    public static int solution(int[] arr) {
        int answer = arr[0];
        ArrayList<Integer> list = new ArrayList<>();
        for (int key : arr) {
            list.add(key);
        }
        for(int i = 1; i < list.size(); i++) {
            answer = getNum(answer, list.get(1));
            list.remove(i - 1);
            list.remove(i - 1);
            list.add(0, answer);
            i = 0;
        }
        return answer;
    }

    public static int getNum(int a, int b) {
        int max = 0, min = 0;
        if(a == b)
            return a;
        if(a > b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }

        int temp = 0;
        while(min > 0) {
            temp = max % min;

            max = min;
            min = temp;
        }
        return max * (a / max) * (b / max);

    }
}
