package programmers.level2;
import java.util.*;
public class n_digitGame { // 3페이지 & n진수 게임
    public static void main(String[] args) {
        System.out.println(solution(16, 16, 2, 1));
    }
    public static String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }
        StringBuilder ans = new StringBuilder();
        for(int i = p - 1; ans.length() < t; i += m) {
            ans.append(sb.charAt(i));
        }
        return ans.toString();
    }
}
