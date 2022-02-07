package programmers.level2;

import java.util.Arrays;
import java.util.Comparator;

public class ArrangeFileNames { // 3페이지 & 파일명 정렬
    public static void main(String[] args) {
        String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2"};
        System.out.println(Arrays.toString(solution(files)));
    }
    public static String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String head1 = o1.split("[0-9]")[0].toLowerCase();
                String head2 = o2.split("[0-9]")[0].toLowerCase();

                int result = head1.compareTo(head2);

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
        for(char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) {
                result += c;
            } else {
                break;
            }
        }
        return Integer.parseInt(result);
    }
}
