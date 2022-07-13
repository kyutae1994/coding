package programmers.level2.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class two {
    public static void main(String[] args) {
        String[] s = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        System.out.println(Arrays.toString(solution(s)));
    }
    public static String[] solution(String[] files) {
        String[] answer = {};

        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0];
                String head2 = o2.split("[0-9]")[0];

                int result = head1.toLowerCase().compareTo(head2.toLowerCase());

                if (result == 0) {
                    result = convertNum(o1, head1) - convertNum(o2, head2);
                }
                return result;
            }
        });

        return files;
    }

    public static int convertNum(String str, String head) {
        str = str.substring(head.length());
        String result = "";
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 6) {
                result += c;
            } else {
                break;
            }
        }
        return Integer.parseInt(result);
    }
}
