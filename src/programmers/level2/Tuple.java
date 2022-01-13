package programmers.level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tuple {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(solution("{{123}}")));
        System.out.println(Arrays.toString(solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"	)));
    }
    public static int[] solution(String s) {

        s = s.substring(1, s.length() - 1).replace("},{", ".");
        s = s.substring(1, s.length() - 1);
        String[] str = s.split("\\.");
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            String[] temp = str[i].split(",");
            for (int j = 0; j < temp.length; j++) {
                if (!list.contains(Integer.parseInt(temp[j])))
                    list.add(Integer.parseInt(temp[j]));
            }
        }

        int[] answer = new int[str.length];
        int cnt = 0;
        for (int key : list) {
            answer[cnt++] = key;
        }

        return answer;
    }
}
