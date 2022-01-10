package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class NewsClustring {
    public static void main(String[] args) {
//        System.out.println(solution("FRANCE", "french"));
//        System.out.println(solution("handshake", "shake hands"));
//        System.out.println(solution("aa1+aa2", "AAAA12"));
        System.out.println(solution("E=M*C^2", "e=m*c^2"));
    }
    public static int solution(String str1, String str2) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 0; i < str1.length() - 1; i++) {
            String tmp = str1.substring(i, i + 2).toLowerCase();
            if (Pattern.matches("^[a-z]*$", tmp)) {
                list1.add(tmp);
            }
        }
        for (int i = 0; i < str2.length() - 1; i++) {
            String tmp = str2.substring(i, i + 2).toLowerCase();
            if (Pattern.matches("^[a-z]*$", tmp)) {
                list2.add(tmp);
            }
        }

        if (list1.size() == 0 && list2.size() == 0)
            return 65536;

        int min = 0;
        int list1Len = list1.size();
        int list2Len = list2.size();
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) {
                    min++;
                    list1.remove(i);
                    list2.remove(j);
                    i--;
                    break;
                }
            }
        }

        return (int) (((double) min / (list1Len + list2Len - min)) * 65536);
    }
}
